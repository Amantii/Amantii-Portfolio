import { ChangeDetectionStrategy, Component, inject } from '@angular/core';
import { toSignal } from '@angular/core/rxjs-interop';

import { ProjectsService } from '../../core/services/project.services';
import { ProjectModel } from '../../core/models/project.model';

@Component({
  selector: 'app-projects',
  templateUrl: './projects.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class ProjectsComponent {
  private readonly projectsService = inject(ProjectsService);

  readonly projects = toSignal(this.projectsService.getProjects(), {
    initialValue: [] as ProjectModel[],
  });
}
