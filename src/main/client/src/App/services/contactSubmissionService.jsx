import {API_URL_BASE} from "../utilities/secureVariables";
import {post} from "../services/apiService"
import {ContactSubmission} from "../models/contactSubmission"

export function postContactSubmission(submission: ContactSubmission): ContactSubmissionResponse {
    let tempSub = submission;
    tempSub.created_at = Date.now();
    tempSub.updated_at = Date.now();
    tempSub.isActive = true;
    return post(API_URL_BASE + "contactSubmission", tempSub);
}