export function get(URL: string, body: any = null) {
    return call(URL, "GET", body);
}

export function post(URL: string, body: any) {
    return call(URL, "POST", body);
}

async function call(URL: string, protocol: string, jsonBody: any) {
    const response = await fetch(URL, {
        method: protocol,
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
        },
        body: jsonBody != null ? JSON.stringify({
            ...jsonBody
        }) : null
    });
    let responseJson = await response.json();
    return responseJson;
}