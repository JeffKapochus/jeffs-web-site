import React from "react";
import "./Home.css";

import { CenterMiddleSection } from "./../../components/centerMiddleSection/CenterMiddleSection";
import { Portfolio } from "./../../components/portfolio/Portfolio";
import { PortfolioPiece } from "./../../components/portfolioPiece/PortfolioPiece";
import { ContactForm } from "./../../components/contactForm/ContactForm";

export class Home extends React.Component {
  render() {
    return (
      <div id="homePage">
        <CenterMiddleSection
          backgroundImage={process.env.PUBLIC_URL + "/images/bg.png"}
          textColor="white"
          align="center"
        >
          <img
            id="literallyMe"
            src={process.env.PUBLIC_URL + "/images/me_small.jpg"}
            alt="Jeff Kapochus headshot"
          />
          <h1>Welcome to Jeff's Web.Site</h1>
          <h2>Digital Portfolio of Jeff Kapochus</h2>
          <h2>Web Developer – Application Developer – Creative Writer</h2>
        </CenterMiddleSection>
        <CenterMiddleSection
          backgroundImage={process.env.PUBLIC_URL + "/images/bg3.png"}
          textColor="white"
        >
        <h3>Portfolio Highlights</h3>
        <Portfolio>
          <PortfolioPiece
            image={process.env.PUBLIC_URL + "/images/orbitalDecay.png"}
            title="Orbital Decay (2020 - Unity)"
            url="https://jeffkapochus.itch.io/orbital-decay"
            extraText={
              <div>
                <p>Built by an Internationally Distributed Team in a <em>Single Month.</em> (April 2020)</p>
                <p>My Noteworthy Contributions:</p>
                  <ul className="contributionList">
                    <li>Grid System and All Movement (including pathfinding)</li>
                    <li>Planet Orbit Mechanics</li>
                    <li>Combat</li>
                    <li>Procedural Generation of Levels and Seeding</li>
                    <li>Rudimentary AI (Artifical Intelligence)</li>
                  </ul>
                <p><a href="https://github.com/JeffKapochus/Orbital-Decay" target="_blank" rel="noopener noreferrer">View on Github</a></p>
              </div>
            }
          />
        </Portfolio>
        </CenterMiddleSection>
        <CenterMiddleSection
          backgroundImage={process.env.PUBLIC_URL + "/images/bg4.png"}
          textColor="black"
        >
          <div className="grid">
            <div className="grid-2" />
            <div className="grid-8">
              <h3>Résumé</h3>
              <h4>Qualifications Profile</h4>
              <p>
                Driven technical professional with 3+ years of software
                development experience, in addition to Computer Science
                training,who seeks a Software Developer or Software Engineer
                role. Key strengths include planning and executing projects,
                learning new technologies, and collaborating with key
                stakeholders. Excellent communication skills, works well in team
                environments.
              </p>
              <h5>Tools and Technologies:</h5>
              <p>
                Java, Spring Boot, C#, .NET Core, ASP.NET, React, Angular,
                jQuery, JavaScript, MySQL, SQL Server, Unity, Docker, HTML, CSS, SOAP,
                REST, Windows, OS X, Linux, Agile Framework, Scrum, Kanban,
                Maven, Gradle, Apache, Tomcat
              </p>
              <h4>Educational Background</h4>
              <p>
                <strong>
                  Bachelor of Science in Computer Science - Graduated Magna Cum
                  Laude - 05/2018
                </strong>
              </p>
              <p>Creative Writing Minor</p>
              <p><a href="http://wcupa.edu/" target="_blank" rel="noopener noreferrer">West Chester University</a>, West Chester PA</p>
              <h4>Experience Highlights</h4>
              <p>
                <strong>GliderTech Ltd</strong>, Clitheroe, UK (Remote 100%)
              </p>
              <p>
                <strong>Software Engineer</strong>, 10/2019 – 06/2020
              </p>
              <p>
                Technologies: React, TypeScript, Redux, C#, .NET, MySQL, Docker, Scrum, Agile
              </p>
              <p>
                Developed, documented, tested, and debugged software modules. Participated in code reviews to ensure code quality, and assisted in creation of design specifications from which software was created. 
              </p>
              <ul>
                <li>
                  Developed entirety of administrative features, including front-end UIs with React and Redux, Back-End logic with C# .Net and XUnit, and database structure with MySQL.
                </li>
              </ul>
              <hr/>
              <p>
                <strong>Cerner Corporation</strong>, Malvern, PA
              </p>
              <p>
                <strong>Academy Software Engineer</strong>, March 2019 - September 2019
              </p>
              <p>
                Technologies: Java, Spring Boot, React, MySQL, Hibernate,
                Docker, Scrum, Agile
              </p>
              <p>
                Responsible for writing code, testing and debugging
                new software, and enhancing existing software from client
                requirements. Participated in code reviews to identify basic
                issues and deviations from best practices. Note: The Academy was
                a several month bootcamp-like program in which junior developers
                were put onto temporary scrum teams working on internal projects
                to learn the ins and outs of real development environments.
              </p>
              <ul>
                <li>
                  Created clean user interfaces using the React library and
                  RESTful microservice APIs utilizing the Spring Boot framework.
                </li>
                <li>
                  Pioneered more efficient database redesign utilizing
                  Hibernate, MySQL, and Java model reworks.
                </li>
              </ul>
              <hr/>
              <p>
                <strong>Lockheed Martin Space</strong>, King of Prussia, PA (Remote 10%)
              </p>
              <p>
                <strong>Software Engineer</strong>, June 2018 - March 2019
              </p>
              <p>
                Technologies: C#, .NET Core, SQL, Angular, Scrum, Agile,
                Postman, PostgreSQL
              </p>
              <p>
                Designed, developed, documented, tested, and debugged software
                that contained logical and mathematical solutions to
                business/mission problems or questions. Ensured software
                standards were met.
              </p>
              <ul>
                <li>
                  Utilized C# and .NET Core to create RESTful microservice APIs
                  that communicated with a PostgreSQL database.
                </li>
                <li>
                  Utilized Angular to create GUIs to test functionality of
                  microservices
                </li>
              </ul>
              <hr/>
              <p>
                <strong>West Chester University</strong>, West Chester, PA (Remote 20%)
              </p>
              <p>
                <strong>Web Team Intern</strong>, September 2015 - June 2018
              </p>
              <p>
                Technologies: C#, ASP.NET, JavaScript, JQuery, MySQL, HTML, CSS
              </p>
              <p>
                Enhanced pages with JavaScript, and ASP.Net/C# forms and
                integrated data flows with the support of MySQL databases.
                Engaged with clients to gather requirements for web page and
                form design projects while maintaining security and compliance.
              </p>
              <ul>
                <li>
                  Spearheaded the optimization of a calendar system for use
                  across the entire university website.
                </li>
                <li>
                  Designed site-wide regular expression system now fully
                  utilized by all team members and staff.
                </li>
              </ul>
            </div>
          </div>
          <div className="grid-2" />
        </CenterMiddleSection>
        <CenterMiddleSection
          backgroundImage={process.env.PUBLIC_URL + "/images/bg2.png"}
          textColor="white"
        >
          <h3>Programming Projects</h3>
          <h4>Finished</h4>
          <Portfolio>
            <PortfolioPiece
              image={process.env.PUBLIC_URL + "/images/orbitalDecay.png"}
              title="Orbital Decay (2020 - Unity)"
              url="https://jeffkapochus.itch.io/orbital-decay"
              extraText={
                <div>
                  <p>Built by an Internationally Distributed Team in a <em>Single Month.</em> (April 2020)</p>
                  <p>My Noteworthy Contributions:</p>
                    <ul className="contributionList">
                      <li>Grid System and All Movement (including pathfinding)</li>
                      <li>Planet Orbit Mechanics</li>
                      <li>Combat</li>
                      <li>Procedural Generation of Levels and Seeding</li>
                      <li>Rudimentary AI (Artifical Intelligence)</li>
                    </ul>
                  <p><a href="https://github.com/JeffKapochus/Orbital-Decay" target="_blank" rel="noopener noreferrer">View on Github</a></p>
                </div>
              }
            />
          </Portfolio>
          <h4>Active</h4>
          <Portfolio>
            <PortfolioPiece
              image={process.env.PUBLIC_URL + "/images/raidworld300x217.png"}
              title="Project Raidworld (2020 - Unity)"
              url="https://github.com/JeffKapochus/Project-RaidWorld"
              extraText="Temporarily on Hold Until May 2020 Due to Project GIAM"
            />
          </Portfolio>
          <h4>Inactive</h4>
          <Portfolio>
            <PortfolioPiece
              image={process.env.PUBLIC_URL + "/images/swIdle300x217.png"}
              title="Star Wars Idle Game (2019 - React)"
              url="/SWIdleGame"
            />
            <PortfolioPiece
              image={process.env.PUBLIC_URL + "/images/not300x217.png"}
              title="Game Dev Project (2018 - Unity)"
              url="/ProjectDelorean"
            />
          </Portfolio>
        </CenterMiddleSection>
        <CenterMiddleSection
          backgroundImage={process.env.PUBLIC_URL + "/images/bg3.png"}
          textColor="white"
          align="center"
        >
          <h3>Writing Projects</h3>
          <h4>Coming Soon</h4>
        </CenterMiddleSection>
        <CenterMiddleSection
          backgroundImage={process.env.PUBLIC_URL + "/images/bg4.png"}
          textColor="black"
        >
          <h3>Contact Me</h3>
          <ContactForm />
        </CenterMiddleSection>
      </div>
    );
  }
}
