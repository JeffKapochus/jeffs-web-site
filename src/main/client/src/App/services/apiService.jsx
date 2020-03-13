export function get(URL: string, body: any = null) {
    return call(URL, "GET", body);
}

export function post(URL: string, body: any) {
    return call(URL, "POST", body);
}

async function call(URL: string, protocol: string, jsonBody: any): JSON {
    return new Promise((resolve, reject) => {
        fetch(URL, {
            method: protocol,
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json',
            },
            body: jsonBody != null ? JSON.stringify({
                ...jsonBody
            }) : null
        }).then((response) => {
            if (response.status !== 200) {
                console.error("A fetch to " + URL + " failed.");
            }
            else {
                response.json().then((json) => {
                    resolve(json);
                });
            }
        });
    });
}