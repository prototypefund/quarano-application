/*
 * SORMAS REST API
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: 1.44.0-SNAPSHOT
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package de.quarano.sormas.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import de.quarano.sormas.client.model.CaseReferenceDto;
import de.quarano.sormas.client.model.ContactReferenceDto;
import de.quarano.sormas.client.model.EventReferenceDto;
import de.quarano.sormas.client.model.ReferenceDto;
import de.quarano.sormas.client.model.TaskContext;
import de.quarano.sormas.client.model.TaskPriority;
import de.quarano.sormas.client.model.TaskStatus;
import de.quarano.sormas.client.model.TaskType;
import de.quarano.sormas.client.model.UserReferenceDto;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.OffsetDateTime;
/**
 * TaskDto
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2020-07-09T17:56:16.099120+02:00[Europe/Berlin]")
public class TaskDto {
  @JsonProperty("creationDate")
  private OffsetDateTime creationDate = null;

  @JsonProperty("changeDate")
  private OffsetDateTime changeDate = null;

  @JsonProperty("uuid")
  private String uuid = null;

  @JsonProperty("taskContext")
  private TaskContext taskContext = null;

  @JsonProperty("caze")
  private CaseReferenceDto caze = null;

  @JsonProperty("event")
  private EventReferenceDto event = null;

  @JsonProperty("contact")
  private ContactReferenceDto contact = null;

  @JsonProperty("taskType")
  private TaskType taskType = null;

  @JsonProperty("priority")
  private TaskPriority priority = null;

  @JsonProperty("dueDate")
  private OffsetDateTime dueDate = null;

  @JsonProperty("suggestedStart")
  private OffsetDateTime suggestedStart = null;

  @JsonProperty("taskStatus")
  private TaskStatus taskStatus = null;

  @JsonProperty("statusChangeDate")
  private OffsetDateTime statusChangeDate = null;

  @JsonProperty("perceivedStart")
  private OffsetDateTime perceivedStart = null;

  @JsonProperty("creatorUser")
  private UserReferenceDto creatorUser = null;

  @JsonProperty("creatorComment")
  private String creatorComment = null;

  @JsonProperty("assigneeUser")
  private UserReferenceDto assigneeUser = null;

  @JsonProperty("assigneeReply")
  private String assigneeReply = null;

  @JsonProperty("closedLat")
  private Double closedLat = null;

  @JsonProperty("closedLon")
  private Double closedLon = null;

  @JsonProperty("closedLatLonAccuracy")
  private Float closedLatLonAccuracy = null;

  @JsonProperty("contextReference")
  private ReferenceDto contextReference = null;

  public TaskDto creationDate(OffsetDateTime creationDate) {
    this.creationDate = creationDate;
    return this;
  }

   /**
   * Get creationDate
   * @return creationDate
  **/
  @Schema(description = "")
  public OffsetDateTime getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(OffsetDateTime creationDate) {
    this.creationDate = creationDate;
  }

  public TaskDto changeDate(OffsetDateTime changeDate) {
    this.changeDate = changeDate;
    return this;
  }

   /**
   * Get changeDate
   * @return changeDate
  **/
  @Schema(description = "")
  public OffsetDateTime getChangeDate() {
    return changeDate;
  }

  public void setChangeDate(OffsetDateTime changeDate) {
    this.changeDate = changeDate;
  }

  public TaskDto uuid(String uuid) {
    this.uuid = uuid;
    return this;
  }

   /**
   * Get uuid
   * @return uuid
  **/
  @Schema(description = "")
  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  public TaskDto taskContext(TaskContext taskContext) {
    this.taskContext = taskContext;
    return this;
  }

   /**
   * Get taskContext
   * @return taskContext
  **/
  @Schema(required = true, description = "")
  public TaskContext getTaskContext() {
    return taskContext;
  }

  public void setTaskContext(TaskContext taskContext) {
    this.taskContext = taskContext;
  }

  public TaskDto caze(CaseReferenceDto caze) {
    this.caze = caze;
    return this;
  }

   /**
   * Get caze
   * @return caze
  **/
  @Schema(description = "")
  public CaseReferenceDto getCaze() {
    return caze;
  }

  public void setCaze(CaseReferenceDto caze) {
    this.caze = caze;
  }

  public TaskDto event(EventReferenceDto event) {
    this.event = event;
    return this;
  }

   /**
   * Get event
   * @return event
  **/
  @Schema(description = "")
  public EventReferenceDto getEvent() {
    return event;
  }

  public void setEvent(EventReferenceDto event) {
    this.event = event;
  }

  public TaskDto contact(ContactReferenceDto contact) {
    this.contact = contact;
    return this;
  }

   /**
   * Get contact
   * @return contact
  **/
  @Schema(description = "")
  public ContactReferenceDto getContact() {
    return contact;
  }

  public void setContact(ContactReferenceDto contact) {
    this.contact = contact;
  }

  public TaskDto taskType(TaskType taskType) {
    this.taskType = taskType;
    return this;
  }

   /**
   * Get taskType
   * @return taskType
  **/
  @Schema(required = true, description = "")
  public TaskType getTaskType() {
    return taskType;
  }

  public void setTaskType(TaskType taskType) {
    this.taskType = taskType;
  }

  public TaskDto priority(TaskPriority priority) {
    this.priority = priority;
    return this;
  }

   /**
   * Get priority
   * @return priority
  **/
  @Schema(description = "")
  public TaskPriority getPriority() {
    return priority;
  }

  public void setPriority(TaskPriority priority) {
    this.priority = priority;
  }

  public TaskDto dueDate(OffsetDateTime dueDate) {
    this.dueDate = dueDate;
    return this;
  }

   /**
   * Get dueDate
   * @return dueDate
  **/
  @Schema(required = true, description = "")
  public OffsetDateTime getDueDate() {
    return dueDate;
  }

  public void setDueDate(OffsetDateTime dueDate) {
    this.dueDate = dueDate;
  }

  public TaskDto suggestedStart(OffsetDateTime suggestedStart) {
    this.suggestedStart = suggestedStart;
    return this;
  }

   /**
   * Get suggestedStart
   * @return suggestedStart
  **/
  @Schema(description = "")
  public OffsetDateTime getSuggestedStart() {
    return suggestedStart;
  }

  public void setSuggestedStart(OffsetDateTime suggestedStart) {
    this.suggestedStart = suggestedStart;
  }

  public TaskDto taskStatus(TaskStatus taskStatus) {
    this.taskStatus = taskStatus;
    return this;
  }

   /**
   * Get taskStatus
   * @return taskStatus
  **/
  @Schema(description = "")
  public TaskStatus getTaskStatus() {
    return taskStatus;
  }

  public void setTaskStatus(TaskStatus taskStatus) {
    this.taskStatus = taskStatus;
  }

  public TaskDto statusChangeDate(OffsetDateTime statusChangeDate) {
    this.statusChangeDate = statusChangeDate;
    return this;
  }

   /**
   * Get statusChangeDate
   * @return statusChangeDate
  **/
  @Schema(description = "")
  public OffsetDateTime getStatusChangeDate() {
    return statusChangeDate;
  }

  public void setStatusChangeDate(OffsetDateTime statusChangeDate) {
    this.statusChangeDate = statusChangeDate;
  }

  public TaskDto perceivedStart(OffsetDateTime perceivedStart) {
    this.perceivedStart = perceivedStart;
    return this;
  }

   /**
   * Get perceivedStart
   * @return perceivedStart
  **/
  @Schema(description = "")
  public OffsetDateTime getPerceivedStart() {
    return perceivedStart;
  }

  public void setPerceivedStart(OffsetDateTime perceivedStart) {
    this.perceivedStart = perceivedStart;
  }

  public TaskDto creatorUser(UserReferenceDto creatorUser) {
    this.creatorUser = creatorUser;
    return this;
  }

   /**
   * Get creatorUser
   * @return creatorUser
  **/
  @Schema(description = "")
  public UserReferenceDto getCreatorUser() {
    return creatorUser;
  }

  public void setCreatorUser(UserReferenceDto creatorUser) {
    this.creatorUser = creatorUser;
  }

  public TaskDto creatorComment(String creatorComment) {
    this.creatorComment = creatorComment;
    return this;
  }

   /**
   * Get creatorComment
   * @return creatorComment
  **/
  @Schema(description = "")
  public String getCreatorComment() {
    return creatorComment;
  }

  public void setCreatorComment(String creatorComment) {
    this.creatorComment = creatorComment;
  }

  public TaskDto assigneeUser(UserReferenceDto assigneeUser) {
    this.assigneeUser = assigneeUser;
    return this;
  }

   /**
   * Get assigneeUser
   * @return assigneeUser
  **/
  @Schema(required = true, description = "")
  public UserReferenceDto getAssigneeUser() {
    return assigneeUser;
  }

  public void setAssigneeUser(UserReferenceDto assigneeUser) {
    this.assigneeUser = assigneeUser;
  }

  public TaskDto assigneeReply(String assigneeReply) {
    this.assigneeReply = assigneeReply;
    return this;
  }

   /**
   * Get assigneeReply
   * @return assigneeReply
  **/
  @Schema(description = "")
  public String getAssigneeReply() {
    return assigneeReply;
  }

  public void setAssigneeReply(String assigneeReply) {
    this.assigneeReply = assigneeReply;
  }

  public TaskDto closedLat(Double closedLat) {
    this.closedLat = closedLat;
    return this;
  }

   /**
   * Get closedLat
   * @return closedLat
  **/
  @Schema(description = "")
  public Double getClosedLat() {
    return closedLat;
  }

  public void setClosedLat(Double closedLat) {
    this.closedLat = closedLat;
  }

  public TaskDto closedLon(Double closedLon) {
    this.closedLon = closedLon;
    return this;
  }

   /**
   * Get closedLon
   * @return closedLon
  **/
  @Schema(description = "")
  public Double getClosedLon() {
    return closedLon;
  }

  public void setClosedLon(Double closedLon) {
    this.closedLon = closedLon;
  }

  public TaskDto closedLatLonAccuracy(Float closedLatLonAccuracy) {
    this.closedLatLonAccuracy = closedLatLonAccuracy;
    return this;
  }

   /**
   * Get closedLatLonAccuracy
   * @return closedLatLonAccuracy
  **/
  @Schema(description = "")
  public Float getClosedLatLonAccuracy() {
    return closedLatLonAccuracy;
  }

  public void setClosedLatLonAccuracy(Float closedLatLonAccuracy) {
    this.closedLatLonAccuracy = closedLatLonAccuracy;
  }

  public TaskDto contextReference(ReferenceDto contextReference) {
    this.contextReference = contextReference;
    return this;
  }

   /**
   * Get contextReference
   * @return contextReference
  **/
  @Schema(description = "")
  public ReferenceDto getContextReference() {
    return contextReference;
  }

  public void setContextReference(ReferenceDto contextReference) {
    this.contextReference = contextReference;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TaskDto taskDto = (TaskDto) o;
    return Objects.equals(this.creationDate, taskDto.creationDate) &&
        Objects.equals(this.changeDate, taskDto.changeDate) &&
        Objects.equals(this.uuid, taskDto.uuid) &&
        Objects.equals(this.taskContext, taskDto.taskContext) &&
        Objects.equals(this.caze, taskDto.caze) &&
        Objects.equals(this.event, taskDto.event) &&
        Objects.equals(this.contact, taskDto.contact) &&
        Objects.equals(this.taskType, taskDto.taskType) &&
        Objects.equals(this.priority, taskDto.priority) &&
        Objects.equals(this.dueDate, taskDto.dueDate) &&
        Objects.equals(this.suggestedStart, taskDto.suggestedStart) &&
        Objects.equals(this.taskStatus, taskDto.taskStatus) &&
        Objects.equals(this.statusChangeDate, taskDto.statusChangeDate) &&
        Objects.equals(this.perceivedStart, taskDto.perceivedStart) &&
        Objects.equals(this.creatorUser, taskDto.creatorUser) &&
        Objects.equals(this.creatorComment, taskDto.creatorComment) &&
        Objects.equals(this.assigneeUser, taskDto.assigneeUser) &&
        Objects.equals(this.assigneeReply, taskDto.assigneeReply) &&
        Objects.equals(this.closedLat, taskDto.closedLat) &&
        Objects.equals(this.closedLon, taskDto.closedLon) &&
        Objects.equals(this.closedLatLonAccuracy, taskDto.closedLatLonAccuracy) &&
        Objects.equals(this.contextReference, taskDto.contextReference);
  }

  @Override
  public int hashCode() {
    return Objects.hash(creationDate, changeDate, uuid, taskContext, caze, event, contact, taskType, priority, dueDate, suggestedStart, taskStatus, statusChangeDate, perceivedStart, creatorUser, creatorComment, assigneeUser, assigneeReply, closedLat, closedLon, closedLatLonAccuracy, contextReference);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TaskDto {\n");
    
    sb.append("    creationDate: ").append(toIndentedString(creationDate)).append("\n");
    sb.append("    changeDate: ").append(toIndentedString(changeDate)).append("\n");
    sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
    sb.append("    taskContext: ").append(toIndentedString(taskContext)).append("\n");
    sb.append("    caze: ").append(toIndentedString(caze)).append("\n");
    sb.append("    event: ").append(toIndentedString(event)).append("\n");
    sb.append("    contact: ").append(toIndentedString(contact)).append("\n");
    sb.append("    taskType: ").append(toIndentedString(taskType)).append("\n");
    sb.append("    priority: ").append(toIndentedString(priority)).append("\n");
    sb.append("    dueDate: ").append(toIndentedString(dueDate)).append("\n");
    sb.append("    suggestedStart: ").append(toIndentedString(suggestedStart)).append("\n");
    sb.append("    taskStatus: ").append(toIndentedString(taskStatus)).append("\n");
    sb.append("    statusChangeDate: ").append(toIndentedString(statusChangeDate)).append("\n");
    sb.append("    perceivedStart: ").append(toIndentedString(perceivedStart)).append("\n");
    sb.append("    creatorUser: ").append(toIndentedString(creatorUser)).append("\n");
    sb.append("    creatorComment: ").append(toIndentedString(creatorComment)).append("\n");
    sb.append("    assigneeUser: ").append(toIndentedString(assigneeUser)).append("\n");
    sb.append("    assigneeReply: ").append(toIndentedString(assigneeReply)).append("\n");
    sb.append("    closedLat: ").append(toIndentedString(closedLat)).append("\n");
    sb.append("    closedLon: ").append(toIndentedString(closedLon)).append("\n");
    sb.append("    closedLatLonAccuracy: ").append(toIndentedString(closedLatLonAccuracy)).append("\n");
    sb.append("    contextReference: ").append(toIndentedString(contextReference)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}
