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
        body: JSON.stringify({
            ...jsonBody
        })
    });
    let responseJson = await response.json();
    return responseJson;
}