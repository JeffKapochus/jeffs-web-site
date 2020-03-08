import { ContactSubmission } from "./contactSubmission";

export class ContactSubmissionResponse {
    submission: ContactSubmission;
    mailResponse: any;
    httpStatus: String;
    validationMessage: String;
}