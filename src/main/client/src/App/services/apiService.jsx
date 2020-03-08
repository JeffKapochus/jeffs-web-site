import React from 'react';

export function get(URL: string, body: any = null) {
    return await fetch(URL, "GET", body);
}

export function post(URL: string, body: any) {
    return await fetch(URL, "POST", body);
}

function fetch(URL: string, protocol: string, body: any) {
    const response = await fetch(URL, {
        method: protocol,
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({
            ...body
        })
    });
    return response;
}