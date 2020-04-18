import React from "react";
import ReCAPTCHA from "react-google-recaptcha";
import "./ContactForm.css";
import {CAPTCHA_SITE_KEY} from "../../utilities/secureVariables"
import {postContactSubmission} from "../../services/contactSubmissionService"
import { ContactSubmission } from "../../models/contactSubmission";
import { ContactSubmissionResponse } from "../../models/contactSubmissionResponse";

export class ContactForm extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      submission: new ContactSubmission(),
      validationMessages: "",
      sentSuccess: false
    };
    this.handleSubmit = this.handleSubmit.bind(this);
    this.handleCaptchaChange = this.handleCaptchaChange.bind(this);
    this.checkClientSideValid = this.checkClientSideValid.bind(this);
  }
  handleCaptchaChange = value => {
    this.setState({
      captchaToken: value
    });
  }
  handleSubmit(event) {
    event.preventDefault();
    if (this.checkClientSideValid) {
      let response: ContactSubmissionResponse = postContactSubmission(this.state.submission);
      console.log(response);
      this.setState({
        validationMessages: response.validationMessage,
        sentSuccess: response.httpStatus === "OK" ? true : false
      });
      if (response.httpStatus === "OK") {
        document.getElementById("contactSubmissionConfirmation").classList.remove("hidden");
        document.getElementById("frmContact").classList.add("hidden");
      }
      else {
        document.getElementById("contactSubmissionError").classList.remove("hidden");
        document.getElementById("frmContact").classList.add("hidden");
      }
    }
    else {
      document.getElementById("contactSubmissionError").classList.remove("hidden");
      document.getElementById("frmContact").classList.add("hidden");
    }
  }
  checkClientSideValid() {
    if (
      this.state.submission.name === "" ||
      this.state.submission.email === "" ||
      this.state.submission.subject === "" ||
      this.state.submission.message === "" ||
      this.state.captchaToken === null
    ) {
      return false;
    }
    return true;
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
                    value={this.state.submission.name}
                    type="text"
                    onChange={(e)=>{
                      let tempSub = this.state.submission;
                      tempSub.name = e.target.value;
                      this.setState({
                        submission: tempSub
                      });
                    }}
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
                    value={this.state.submission.email}
                    type="email"
                    onChange={(e)=>{
                      let tempSub = this.state.submission;
                      tempSub.email = e.target.value;
                      this.setState({
                        submission: tempSub
                      });
                    }}
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
                    value={this.state.submission.subject}
                    type="text"
                    onChange={(e)=>{
                      let tempSub = this.state.submission;
                      tempSub.subject = e.target.value;
                      this.setState({
                        submission: tempSub
                      });
                    }}
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
                    value={this.state.submission.content}
                    type="text"
                    onChange={(e)=>{
                      let tempSub = this.state.submission;
                      tempSub.content = e.target.value;
                      this.setState({
                        submission: tempSub
                      });
                    }}
                  />
                </div>
              </div>
              <div className="grid-12">
                <div className="grid-12">
                  <ReCAPTCHA
                    sitekey={CAPTCHA_SITE_KEY}
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
              {this.state.validationMessages}
            </div>
          </div>
        </div>
      </div>
    );
  }
}
