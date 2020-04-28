/*
 * Copyright 2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package quarano.department;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.Value;
import lombok.experimental.Accessors;
import quarano.core.QuaranoAggregate;
import quarano.department.Department.DepartmentIdentifier;
import quarano.department.TrackedCase.TrackedCaseIdentifier;
import quarano.tracking.ContactPerson;
import quarano.tracking.Quarantine;
import quarano.tracking.TrackedPerson;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.jddd.core.types.Identifier;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;

/**
 * @author Oliver Drotbohm
 */
@Entity
@Data
@Setter(AccessLevel.PACKAGE)
@EqualsAndHashCode(callSuper = true, of = {})
@Accessors(chain = true)
public class TrackedCase extends QuaranoAggregate<TrackedCase, TrackedCaseIdentifier> {

	private @OneToOne(cascade = { CascadeType.ALL }) TrackedPerson trackedPerson;
	private @ManyToOne Department department;

	@Setter(AccessLevel.NONE) @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true) //
	private InitialReport initialReport;

	@Setter(AccessLevel.NONE) private Enrollment enrollment = new Enrollment();
	private @Getter @Setter CaseType type = CaseType.INDEX;
	private @Getter @Setter Quarantine quarantine = null;
	private @Getter @Setter LocalDate testDate;

	@OneToMany(cascade = { CascadeType.ALL }) @Getter //
	private List<ContactPerson> originContacts = new ArrayList<>();

	@OneToMany(cascade = { CascadeType.ALL }) @Getter //
	private List<Comment> comments = new ArrayList<>();

	private @Getter @Setter boolean infected;
	private @Getter boolean concluded;

	@SuppressWarnings("unused")
	private TrackedCase() {
		this.id = TrackedCaseIdentifier.of(UUID.randomUUID());
	}

	public TrackedCase(TrackedPerson person, CaseType type, Department department) {
		this(TrackedCaseIdentifier.of(UUID.randomUUID()), person, type, department, null);
	}

	public TrackedCase(TrackedPerson person, CaseType type, Department department,
			@Nullable ContactPerson contactPerson) {
		this(TrackedCaseIdentifier.of(UUID.randomUUID()), person, type, department, contactPerson);
	}

	TrackedCase(TrackedCaseIdentifier id, TrackedPerson person, CaseType type, Department department,
			@Nullable ContactPerson originContact) {

		this.id = id;
		this.trackedPerson = person;
		this.type = type;
		this.department = department;
		this.infected = false;
		this.concluded = false;

		if (originContact != null) {
			this.originContacts.add(originContact);
		}
	}

	public TrackedCase addComment(String comment) {

		Assert.hasText(comment, "Comment must not be null or empty!");

		this.comments.add(new Comment(comment));

		return this;
	}

	public void addOriginContact(ContactPerson contact) {

		if (!originContacts.contains(contact)) {
			this.originContacts.add(contact);
		}
	}

	public boolean isIndexCase() {
		return type.equals(CaseType.INDEX);
	}

	public boolean isContactCase() {
		return type.equals(CaseType.CONTACT);
	}

	public boolean isMedicalContactCase() {
		return type.equals(CaseType.CONTACT_MEDICAL);
	}

	public boolean isInQuarantine() {
		return quarantine != null;
	}

	public InitialReport getOrCreateInitialReport() {
		return initialReport == null ? new InitialReport() : initialReport;
	}

	public TrackedCase submitEnrollmentDetails() {

		if (trackedPerson.isDetailsCompleted()) {
			this.enrollment.markDetailsSubmitted();
		}

		return this;
	}

	public TrackedCase conclude() {

		this.concluded = true;
		registerEvent(CaseConcluded.of(id));

		return this;
	}

	public TrackedCase submitQuestionnaire(InitialReport report) {

		this.initialReport = report;

		if (report.isComplete()) {
			enrollment.markQuestionaireSubmitted();
		}

		return this;
	}

	public TrackedCase markEnrollmentCompleted(EnrollmentCompletion completion) {

		if (!completion.verify(trackedPerson.getEncounters())) {
			throw new EnrollmentException("No encounters registered so far! Explicit acknowledgement needed!");
		}

		this.enrollment.markEnrollmentCompleted();

		return this;
	}

	public TrackedCase reopenEnrollment() {

		this.enrollment.reopenEnrollment();

		return this;
	}

	public boolean belongsTo(Department department) {
		return this.department.equals(department);
	}

	public boolean belongsTo(DepartmentIdentifier id) {
		return this.department.hasId(id);
	}

	@Value(staticConstructor = "of")
	public static class CaseConcluded {
		TrackedCaseIdentifier caseIdentifier;
	}

	@Embeddable
	@EqualsAndHashCode
	@RequiredArgsConstructor(staticName = "of")
	@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
	public static class TrackedCaseIdentifier implements Identifier, Serializable {
		private static final long serialVersionUID = -1255657328932035265L;
		final UUID id;

		/*
		 * (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return id.toString();
		}
	}
}
