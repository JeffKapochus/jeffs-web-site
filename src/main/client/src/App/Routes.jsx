import React from "react";
import { BrowserRouter, Route } from "react-router-dom";
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faEnvelope } from '@fortawesome/free-solid-svg-icons'
import { faTwitter } from '@fortawesome/free-brands-svg-icons'
import { faLinkedin } from '@fortawesome/free-brands-svg-icons'
import { faGithub } from '@fortawesome/free-brands-svg-icons'
import { Home } from "./components/home/Home";
import { Link } from "react-router-dom";
import { Status } from "./components/status/Status"

const Routes = () => (
  <BrowserRouter basename="/">
    <div id="header">
      <ul id="navLinks">
        <li><Link to="/" title="Home">Home</Link></li>
      </ul>
      <ul id="headSocMedLinks">
        <li><a href="https://twitter.com/JeffKapochus" title="Twitter" target="_blank" rel="noopener noreferrer"><FontAwesomeIcon icon={faTwitter}/></a></li>
        <li><a href="https://www.linkedin.com/in/jeff-kapochus/" title="LinkedIn" target="_blank" rel="noopener noreferrer"><FontAwesomeIcon icon={faLinkedin}/></a></li>
        <li><a href="https://github.com/JeffKapochus" title="GitHub" target="_blank" rel="noopener noreferrer"><FontAwesomeIcon icon={faGithub}/></a></li>
        <li><a href="mailto:jeff.kapochus@gmail.com"><FontAwesomeIcon icon={faEnvelope}/></a></li>
      </ul>
    </div>
    <div id="routerContent">
      <Route exact path="/" component={Home} />
      <Route exact path="/status" component={Status} />
    </div>
    <div id="footer">
      <div className="grid">
        <div className="grid-4">
          <p>Location:</p>
          <p>Greater Philadelphia Area</p>
          <p>Pennsylvania, USA</p>
        </div>
        <div className="grid-4">
          <p>Social Media:</p>
          <ul id="footSocMedLinks">
            <li><a href="https://twitter.com/JeffKapochus" title="Twitter" target="_blank" rel="noopener noreferrer"><FontAwesomeIcon icon={faTwitter}/></a></li>
            <li><a href="https://www.linkedin.com/in/jeff-kapochus/" title="LinkedIn" target="_blank" rel="noopener noreferrer"><FontAwesomeIcon icon={faLinkedin}/></a></li>
            <li><a href="https://github.com/JeffKapochus" title="GitHub" target="_blank" rel="noopener noreferrer"><FontAwesomeIcon icon={faGithub}/></a></li>
            <li><a href="mailto:jeff.kapochus@gmail.com" title="Email"><FontAwesomeIcon icon={faEnvelope}/></a></li>
          </ul>
        </div>
        <div className="grid-4">
          <p><img id="footerImg" src={process.env.PUBLIC_URL + "/images/obi.jpg"} alt="Obi-Wan Kapochus, the Best Boy"/></p>
        </div>
      </div>
      <div id="copyrightDiv">
      © Jeff Kapochus 2016 - {new Date().getFullYear()}
      </div>
    </div>
  </BrowserRouter>
);

export default Routes;
