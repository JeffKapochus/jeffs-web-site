import API_URL_BASE from "../utilities/secureVariables";
import {get, post} from "../services/apiService"

export function postContactSubmission(body) {
    post(API_URL_BASE + "/contactSubmission", body)
}