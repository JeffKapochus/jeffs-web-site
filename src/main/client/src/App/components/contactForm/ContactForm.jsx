import React from "react";
import ReCAPTCHA from "react-google-recaptcha";
import "./ContactForm.css";

const SITE_KEY = "CENSORED";
const URL = "CENSORED";

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
    this.postContactSubmission = this.postContactSubmission.bind(this);
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
      this.postContactSubmission();
      document.getElementById("contactSubmissionConfirmation").classList.remove("hidden");
      document.getElementById("frmContact").classList.add("hidden");
    } else {
      document.getElementById("contactSubmissionError").classList.remove("hidden");
      document.getElementById("frmContact").classList.add("hidden");
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
  async postContactSubmission(){
    const response = await fetch(URL, {
      method: 'POST',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({
        name: this.state.name,
        email: this.state.email,
        subject: this.state.subject,
        content: this.state.message,
        created_at: Date.now(),
        updated_at: Date.now(),
        isActive: true
      })
    });
    if(response.status === 200){
      return true;
    }
    else{
      return false;
    }
  }
  render() {
    return (
      <div className="contactSection">
        <div className="grid">
          <div className="contactForm">
            <form id="frmContact" onSubmit={this.handleSubmit}>
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
                    type="email"
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
            <div id="contactSubmissionConfirmation" className="hidden">
              <label>Your email has successfully been sent!</label>
            </div>
            <div id="contactSubmissionError" className="hidden">
              <label>Something has gone wrong and your email was not properly sent. Please try again later.</label>
            </div>
          </div>
        </div>
      </div>
    );
  }
}
