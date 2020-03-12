import React from "react";
import {getStatus} from "../../services/statusService"

export class Status extends React.Component {

  constructor(props) {
    super(props);

    this.state = {
      responseBody: "Community Warehouse Project Back-End is Currently Down"
    };
  }

  componentDidMount() {
    let test = getStatus();
    console.log(test);
  }

  render() {
    return <div id="homePage">{this.state.responseBody}</div>;
  }
}
