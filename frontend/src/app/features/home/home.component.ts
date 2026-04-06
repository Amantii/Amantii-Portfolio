import { ChangeDetectionStrategy, Component, signal } from '@angular/core';
import { RouterLink } from '@angular/router';
import { SkillGroup } from '../../core/models/skill-group.model';

@Component({
  selector: 'app-home',
  imports: [RouterLink],
  templateUrl: './home.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class HomeComponent {

  readonly techStack = signal<SkillGroup[]>([
    {
      category: 'Frontend',
      skills: [
        { name: 'Angular', icon: 'devicon-angularjs-plain' },
        { name: 'TypeScript', icon: 'devicon-typescript-plain' },
        { name: 'Next.js', icon: 'devicon-nextjs-plain' }
      ]
    },
    {
      category: 'Backend',
      skills: [
        { name: 'Java', icon: 'devicon-java-plain' },
        { name: 'Spring Boot', icon: 'devicon-spring-plain' },
      { name: 'Python', icon: 'devicon-python-plain' },
      { name: 'Node.js', icon: 'devicon-nodejs-plain' }
      ]
    },
    {
      category: 'AI & APIs',
      skills: [
        { name: 'Claude API', icon: 'devicon-anthropic-plain' },
        { name: 'OpenAI', icon: 'devicon-openai-plain' },
        { name: 'FastAPI', icon: 'devicon-fastapi-plain' },
      ]
    },
    {
      category: 'Tools & Infra',
      skills: [
        { name: 'Docker', icon: 'devicon-docker-plain' },
        { name: 'Git', icon: 'devicon-git-plain' },
        { name: 'PostgreSQL', icon: 'devicon-postgresql-plain' },
        { name: 'AWS', icon: 'devicon-amazonwebservices-plain' },
      ]
    }
  ]);
}
