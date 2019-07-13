import React from "react";

export class Status extends React.Component {
  constructor(props) {
    super(props);

    this.state = {
      responseBody: "Community Warehouse Project Back-End is Currently Down"
    };

    this.fetchAndProcessData = this.fetchAndProcessData.bind(this);
  }
  componentDidMount() {
    this.fetchAndProcessData("http://localhost:8080/", "GET");
  }
  async fetchAndProcessData(
    url,
    type,
    body,
    successCallback = () => {},
    errorCallback = () => {}
  ) {
    try {
      let response = await fetch(url, {
        method: type,
        body: body,
        headers: {
          "Content-type": "application/json; charset=UTF-8"
        }
      });
      if (response.status === 200) {
        this.setState({
          responseBody:
            "Community Warehouse Project Back-End is Currently Up and Running"
        });
      }
    } catch {}
  }
  render() {
    return <div id="homePage">{this.state.responseBody}</div>;
  }
}
