import { Routes } from '@angular/router';
import { ProjectsComponent } from './features/projects/projects.component';
import { ExperienceComponent } from './features/experience/experience.component';
import { HomeComponent } from './features/home/home.component';

export const routes: Routes = [
    
    {
        path: '',
        component: HomeComponent
    },
    {
        path: 'projects',
        component: ProjectsComponent
    },
    {
        path: 'experience',
        component: ExperienceComponent
    },
    {
        path: '**',
        redirectTo: ''
    }
];
