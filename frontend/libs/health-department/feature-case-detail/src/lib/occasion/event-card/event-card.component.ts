import { Component, Input } from '@angular/core';
import { HealthDepartmentService } from '@qro/health-department/domain';
import { EventNewDialogComponent } from '../event-new-dialog/event-new-dialog.component';
import { filter, take } from 'rxjs/operators';
import { MatDialog } from '@angular/material/dialog';
import { SubSink } from 'subsink';
import { OccasionDto } from '../../../../../domain/src/lib/model/occasion';
import { OccasionService } from '../occasion.service';

@Component({
  selector: 'qro-event-card',
  templateUrl: './event-card.component.html',
  styleUrls: ['./event-card.component.scss'],
})
export class EventCardComponent {
  @Input()
  occasion: OccasionDto;

  subs = new SubSink();

  constructor(private occasionService: OccasionService, private dialog: MatDialog) {}

  deleteOccasion() {
    this.occasionService.deleteOccasion(this.occasion).subscribe((value) => console.log(value));
  }

  editOccasion(occasion: OccasionDto) {
    const dialogRef = this.dialog.open(EventNewDialogComponent);
    dialogRef.componentInstance.occasion(occasion);
    this.subs.add(
      dialogRef
        .afterClosed()
        .pipe(filter((occasionData) => occasionData))
        .subscribe((occasionData) => this.saveOccasion(occasionData))
    );
  }

  private saveOccasion(occasion: OccasionDto) {
    return this.occasionService
      .editOccasion('5fb8456d-7763-468c-bfc2-ce37a9e0bff6', occasion)
      .pipe(take(1))
      .subscribe((response) => console.log('backendResponse:', response));
  }
}
