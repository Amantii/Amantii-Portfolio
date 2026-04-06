import { HttpClient } from "@angular/common/http";
import { Injectable, inject } from "@angular/core";
import { environment } from "../../../environments/environment";
import { Observable } from "rxjs";
import { ExperienceModel } from "../models/experience.model";


@Injectable({ providedIn: 'root' })
export class ExperienceService {
    private readonly http = inject(HttpClient);
    private readonly baseUrl = environment.apiBaseUrl;

    getExperiences(): Observable<ExperienceModel[]> {
        return this.http.get<ExperienceModel[]>(`${this.baseUrl}/api/experiences`);
    }
}