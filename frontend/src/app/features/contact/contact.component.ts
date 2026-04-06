import { ChangeDetectionStrategy, Component, signal } from '@angular/core';
import { FormsModule } from '@angular/forms';
import emailjs from '@emailjs/browser';
import { environment } from '../../../environments/environment';
import { ContactForm } from '../../core/models/contact-form.model';
import { STATUS } from '../../core/enums/status.enum';

@Component({
  selector: 'app-contact-form',
  imports: [FormsModule],
  templateUrl: './contact.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class ContactComponent {

  form = signal<ContactForm>({ fromName: '', fromEmail: '', message: '' });
  status = signal<STATUS>(STATUS.IDLE);
  readonly sendingStatus = STATUS;

  async onSubmit() {
    this.status.set(STATUS.SENDING);
    try {
      await emailjs.send(
        environment.emailJs.serviceId,
        environment.emailJs.templateId,
        {
          from_name: this.form().fromName,
          from_email: this.form().fromEmail,
          message: this.form().message,
        },
        environment.emailJs.publicKey
      );
      this.status.set(STATUS.SUCCESS);
      this.form.set({ fromName: '', fromEmail: '', message: '' });
    } catch {
      this.status.set(STATUS.ERROR);
    }
  }
}
