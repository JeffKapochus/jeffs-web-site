import React from "react";
import { getStatus } from "../../services/statusService"

export class Status extends React.Component {

  constructor(props) {
    super(props);

    this.state = {
      loading: true,
      status: ""
    };
  }

  async componentDidMount() {
    let statusResponse = await getStatus();
    if (statusResponse != null) {
      this.setState({
        loading: false,
        status: statusResponse.response
      });
    }
  }

  render() {
    return <div id="homePage">{this.state.loading ? "Loading..." : this.state.status}</div>;
  }
}
