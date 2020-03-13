import {API_URL_BASE} from "../utilities/secureVariables";
import {get} from "./apiService"

export function getStatus() {
    return get(API_URL_BASE);
}