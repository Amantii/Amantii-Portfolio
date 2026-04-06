import { inject, Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

import { environment } from '../../../environments/environment';
import { PageViewModel } from '../models/page-view.model';

@Injectable({ providedIn: 'root' })
export class AnalyticsService {
    private readonly http = inject(HttpClient);
    private readonly baseUrl = environment.apiBaseUrl;

    saveView(pageView: PageViewModel): Observable<void> {
        return this.http.post<void>(`${this.baseUrl}/api/views`, pageView);
    }
}