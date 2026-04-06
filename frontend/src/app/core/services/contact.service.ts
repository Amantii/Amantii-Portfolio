import { HttpClient } from '@angular/common/http';
import { environment } from '../../../environments/environment';
import { ContactMessageModel } from '../models/contact-message.model';
import { inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';


@Injectable({ providedIn: 'root' })
export class ContactService {
    private readonly http = inject(HttpClient);
    private readonly baseUrl = environment.apiBaseUrl;

    saveContact(contact: ContactMessageModel): Observable<void> {
        return this.http.post<void>(`${this.baseUrl}/api/contact`, contact);
    }
}