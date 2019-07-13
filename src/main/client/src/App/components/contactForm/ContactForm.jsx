import React from "react";
import "./ContactForm.css";

export class ContactForm extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      name: "",
      email: "",
      subject: "",
      message: ""
    };
    this.handleInputChange = this.handleInputChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
    this.checkClientSideValid = this.checkClientSideValid.bind(this);
  }
  handleInputChange(event) {
    const target = event.target;
    const value = target.value;
    const name = target.name;

    this.setState({
      [name]: value
    });
  }
  handleSubmit(event) {
    event.preventDefault();
    if (this.checkClientSideValid) {
      console.log("Hello, " + this.state.name + ", your email has been sent.");
    } else {
      console.log("NO WAY");
    }
  }
  checkClientSideValid() {
    if (
      this.state.name === "" ||
      this.state.email === "" ||
      this.state.subject === "" ||
      this.state.message === ""
    ) {
      return false;
    }
    return true;
  }
  render() {
    return (
      <div className="contactForm">
        <div className="grid">
          <form onSubmit={this.handleSubmit}>
            <div className="grid-12">
              <div className="grid-12">
                <label for="txtName">Your Name (Required):</label>
              </div>
              <div className="grid-12">
                <input
                  id="txtName"
                  name="name"
                  value={this.state.name}
                  type="text"
                  onChange={this.handleInputChange}
                />
              </div>
            </div>
            <div className="grid-12">
              <div className="grid-12">
                <label for="txtEmail">Your Email Address (Required):</label>
              </div>
              <div className="grid-12">
                <input
                  id="txtEmail"
                  name="email"
                  value={this.state.email}
                  type="text"
                  onChange={this.handleInputChange}
                />
              </div>
            </div>
            <div className="grid-12">
              <div className="grid-12">
                <label for="txtSubject">Message Subject (Required):</label>
              </div>
              <div className="grid-12">
                <input
                  id="txtSubject"
                  name="subject"
                  value={this.state.subject}
                  type="text"
                  onChange={this.handleInputChange}
                />
              </div>
            </div>
            <div className="grid-12">
              <div className="grid-12">
                <label for="txtContent">Message Content (Required):</label>
              </div>
              <div className="grid-12">
                <textarea
                  id="txtContent"
                  name="message"
                  value={this.state.message}
                  type="text"
                  onChange={this.handleInputChange}
                />
              </div>
            </div>
            <div className="grid-12">
              <button
                type="submit"
                value="Submit"
                disabled={!this.checkClientSideValid()}
              >
                Submit
              </button>
            </div>
          </form>
        </div>
      </div>
    );
  }
}
