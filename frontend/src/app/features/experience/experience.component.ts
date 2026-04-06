import { ChangeDetectionStrategy, Component, inject, signal } from '@angular/core';
import { ExperienceModel } from '../../core/models/experience.model';
import { toSignal } from '@angular/core/rxjs-interop';
import { ExperienceService } from '../../core/services/experience.service';

@Component({
  selector: 'app-experience',
  templateUrl: './experience.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class ExperienceComponent {

  //String Variables
  protected readonly presentStr = 'Present';

  //Dependency Injections
  private readonly experienceService = inject(ExperienceService);

  // readonly experiences = signal<ExperienceModel[]>([
  //   {
  //     company: 'General Motors',
  //     location: 'Roswell, GA',
  //     role: 'Senior Software Engineer',
  //     roleDescription: [
  //       'Architected scalable Angular/TypeScript frontends used by thousands of dealership users globally',
  //       'Built reusable component libraries standardizing UI across multiple enterprise apps',
  //       'Delivered 300+ production features with zero critical regressions',
  //       'Migrated legacy platforms to Angular 18, reducing technical debt',
  //       'Integrated OpenAI APIs to automate repetitive user actions and enhance decision support',
  //       'Mentored junior engineers and led code reviews enforcing scalable frontend standards',
  //       'Integrated frontend pipelines into CI/CD workflows, improving deployment reliability',
  //     ],
  //     startDate: '2022',
  //     endDate: null,
  //   },
  //   {
  //       company: 'General Motors',
  //     location: 'Roswell, GA',
  //     role: 'Software Engineer in Test',
  //     roleDescription: [
  //       'Expanded automated test coverage across frontend and API systems',
  //       'Built scalable UI and integration testing frameworks, reducing regression risk',
  //       'Shortened release cycles by embedding automated tests into CI/CD pipelines'
  //     ],
  //     startDate: '2021',
  //     endDate: '2022',
  //   }
  // ]);

  readonly experience = toSignal(this.experienceService.getExperiences(), {
    initialValue: [] as ExperienceModel[],
  });
}
