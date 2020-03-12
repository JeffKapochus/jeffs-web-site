import {API_URL_BASE} from "../utilities/secureVariables";
import {get} from "../services/apiService"

export function getStatus(): String {
    return get(API_URL_BASE);
}