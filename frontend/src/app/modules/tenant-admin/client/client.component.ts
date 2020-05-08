import {ActivatedRoute, Router} from '@angular/router';
import {Component, OnDestroy, OnInit, ViewChild} from '@angular/core';
import {CaseDetailDto} from '@models/case-detail';
import {merge, Observable, Subject} from 'rxjs';
import {filter, map, switchMap, take} from 'rxjs/operators';
import {ApiService} from '@services/api.service';
import {SnackbarService} from '@services/snackbar.service';
import {CaseActionDto} from '@models/case-action';
import {MatTabGroup} from '@angular/material/tabs';
import {StartTracking} from '@models/start-tracking';
import {HalResponse} from '@models/hal-response';
import {CaseCommentDto} from '@models/case-comment';
import {ClientType} from '@models/report-case';
import {MatDialog} from '@angular/material/dialog';
import {CloseCaseDialogComponent, CloseCaseDialogResponse} from './close-case-dialog/close-case-dialog.component';
import {SubSink} from 'subsink';


@Component({
  selector: 'app-clients',
  templateUrl: './client.component.html',
  styleUrls: ['./client.component.scss']
})
export class ClientComponent implements OnInit, OnDestroy {
  caseId: string;
  type: ClientType;
  ClientType = ClientType;

  caseDetail$: Observable<CaseDetailDto>;
  caseAction$: Observable<CaseActionDto>;

  caseComments$: Observable<CaseCommentDto[]>;

  updatedDetail$$: Subject<CaseDetailDto> = new Subject<CaseDetailDto>();
  trackingStart$$: Subject<StartTracking> = new Subject<StartTracking>();

  @ViewChild('tabs', {static: false})
  tabGroup: MatTabGroup;

  tabIndex = 0;

  private subs = new SubSink();

  constructor(
    private route: ActivatedRoute, private router: Router,
    private apiService: ApiService, private snackbarService: SnackbarService,
    private matDialog: MatDialog) {

  }

  ngOnInit(): void {
    this.caseDetail$ = merge(
      this.route.data.pipe(map((data) => data.case)),
      this.updatedDetail$$
    ).pipe(map((data) => data));

    this.caseAction$ = this.route.data.pipe(map((data) => data.actions));
    this.caseComments$ = this.caseDetail$.pipe(map((details) => details?.comments));

    if (this.route.snapshot.queryParamMap.has('tab')) {
      this.tabIndex = Number(this.route.snapshot.queryParamMap.get('tab'));
    }
    if (this.route.snapshot.paramMap.has('id')) {
      this.caseId = this.route.snapshot.paramMap.get('id');
    }
    if (this.route.snapshot.paramMap.has('type')) {
      this.type = this.route.snapshot.paramMap.get('type') as ClientType;
    }

    this.subs.sink = this.caseDetail$.pipe(
      filter((data) => data !== null),
      filter((data) => data?._links?.hasOwnProperty('renew') && data?._links?.hasOwnProperty('start-tracking')),
      take(1)).subscribe((data) => {
        this.subs.sink = this.apiService
          .getApiCall<StartTracking>(data, 'start-tracking')
          .subscribe((sartTracking) => {
            this.trackingStart$$.next(sartTracking);
          });
      }
    );
  }

  hasOpenAnomalies(): Observable<boolean> {
    return this.caseAction$.pipe(map(a => (a.anomalies.health.length + a.anomalies.process.length) > 0));
  }


  saveCaseData(caseDetail: CaseDetailDto) {
    let saveData$: Observable<any>;
    if (!caseDetail.caseId) {
      saveData$ = this.apiService.createCase(caseDetail, this.type);
    } else {
      saveData$ = this.apiService.updateCase(caseDetail, this.type);
    }

    this.subs.sink = saveData$.subscribe(() => {
      this.snackbarService.success('Persönliche Daten erfolgreich aktualisiert');
      this.router.navigate(['/tenant-admin/clients']);
    });
  }

  startTracking(caseDetail: CaseDetailDto) {
    this.subs.sink = this.apiService.putApiCall<StartTracking>(caseDetail, 'start-tracking')
      .subscribe((data) => {
        this.trackingStart$$.next(data);
        this.tabIndex = 3;
      });
  }

  renewTracking(tracking: HalResponse) {
    this.subs.sink = this.apiService.putApiCall<StartTracking>(tracking, 'renew')
      .subscribe((data) => {
        this.trackingStart$$.next(data);
        this.tabIndex = 3;
      });
  }

  addComment(commentText: string) {
    this.subs.sink = this.apiService.addComment(this.caseId, commentText).subscribe((data) => {
      this.snackbarService.success('Kommentar erfolgreich eingetragen.');
      this.updatedDetail$$.next(data);
    });
  }

  checkForClose(halResponse: HalResponse) {
    this.subs.sink = this.matDialog.open(CloseCaseDialogComponent, {width: '640px'}).afterClosed().pipe(
      map((response: CloseCaseDialogResponse) => {
        if (response.confirmation) {
          this.closeCase(halResponse);
        }
        return response;
      }),
      map((response: CloseCaseDialogResponse) => {
        if (response.comment && response.confirmation) {
          this.addComment(response.comment);
        }
      })
    ).subscribe();
  }

  closeCase(halResponse: HalResponse) {
    this.subs.sink = this.apiService.deleteApiCall<any>(halResponse, 'conclude').pipe(
      switchMap(() => this.apiService.getCase(this.caseId))
    ).subscribe((data) => {
      this.snackbarService.success('Fall abgeschlossen.');
      this.updatedDetail$$.next(data);
    });
  }

  ngOnDestroy() {
    this.subs.unsubscribe();
  }
}
