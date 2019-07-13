import React from "react";
import ReCAPTCHA from "react-google-recaptcha";
import "./ContactForm.css";

const SITE_KEY = "6Lcu3jUUAAAAAKgA6-myODOcndPRyeCo3MS1kR_X";

export class ContactForm extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      name: "",
      email: "",
      subject: "",
      message: "",
      captchaToken: null
    };
    this.handleInputChange = this.handleInputChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
    this.handleCaptchaChange = this.handleCaptchaChange.bind(this);
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
  handleCaptchaChange = value => {
    this.setState({
      captchaToken: value
    });
    console.log("Yup");
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
      this.state.message === "" ||
      this.state.captchaToken === null
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
                <label htmlFor="txtName">Your Name (Required):</label>
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
                <label htmlFor="txtEmail">Your Email Address (Required):</label>
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
                <label htmlFor="txtSubject">Message Subject (Required):</label>
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
                <label htmlFor="txtContent">Message Content (Required):</label>
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
              <div className="grid-12">
                <ReCAPTCHA
                  sitekey={SITE_KEY}
                  onChange={this.handleCaptchaChange}
                />
              </div>
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
