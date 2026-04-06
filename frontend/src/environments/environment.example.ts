// Copy this file to environment.ts (dev) and environment.prod.ts (prod)
// and fill in your real values. Never commit the actual environment files.
export const environment = {
  production: false,
  apiBaseUrl: 'http://localhost:8080',
  emailJs: {
    serviceId: 'YOUR_EMAILJS_SERVICE_ID',
    templateId: 'YOUR_EMAILJS_TEMPLATE_ID',
    publicKey: 'YOUR_EMAILJS_PUBLIC_KEY'
  }
};
