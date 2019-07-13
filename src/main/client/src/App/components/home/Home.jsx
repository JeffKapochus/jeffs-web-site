import React from "react";
import "./Home.css";

import { CenterMiddleSection } from "./../../components/centerMiddleSection/CenterMiddleSection";

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
          <h1>Digital Portfolio of Jeff Kapochus</h1>
          <h2>Web Developer – Application Developer – Creative Writer</h2>
          <h2>This Guy Writes Code</h2>
        </CenterMiddleSection>
        <CenterMiddleSection
          backgroundImage={process.env.PUBLIC_URL + "/images/bg4.png"}
          textColor="black"
        >
          <div className="grid">
            <div className="grid-2"></div>
            <div className="grid-8">
            <h3>Résumé</h3>
            <h4>Qualifications Profile</h4>
            <p>
              Driven technical professional with 3+ years of software development
              experience, in addition to Computer Science training,who seeks a
              Software Developer or Software Engineer role. Key strengths include
              planning and executing projects, learning new technologies, and
              collaborating with key stakeholders. Excellent communication skills,
              works well in team environments.
            </p>
            <h5>Tools and Technologies:</h5>
            <p>
              Java, Spring Boot, C#, .NET Core, ASP.NET, React, Angular, jQuery, JavaScript, MySQL, SQL Server, Docker, HTML, CSS, SOAP, REST, Windows, OS X, Linux,
              Agile Framework, Scrum, Kanban, Unity, Maven, Gradle, Apache, Tomcat
            </p>
            <h4>Educational Backgrounds</h4>
            <p>
              <strong>
                Bachelor of Science in Computer Science - Graduated Magna Cum
                Laude - 05/2018
              </strong>
            </p>
            <p>West Chester University, West Chester PA</p>
            <p>
              <strong>
                CompTIA A+ Certification – 2014 | Cisco IT Essentials Curriculum –
                2014
              </strong>
            </p>
            <h4>Experience Highlights</h4>
            <p>
              <strong>Cerner Corporation</strong>, Malvern, PA
            </p>
            <p>
              <strong>Academy Software Engineer</strong>, March 2019 - Present
            </p>
            <p>
              Technologies: Java, Spring Boot, React, MySQL, Hibernate, Docker,
              Scrum, Agile
            </p>
            <p>
              Responsible for writing code, testing and debugging new software,
              and enhancing existing software from client requirements.
              Participated in code reviews to identify basic issues and deviations
              from best practices. Note: The Academy was a two month bootcamp-like
              program in which junior developers were put onto temporary scrum
              teams working on internal projects to learn the ins and outs of real
              development environments.
            </p>
            <ul>
              <li>
                Created clean user interfaces using the React library and RESTful
                microservice APIs utilizing the Spring Boot framework.
              </li>
              <li>
                Pioneered more efficient database redesign utilizing Hibernate,
                MySQL, and Java model reworks.
              </li>
            </ul>
            <p>
              <strong>Lockheed Martin Space</strong>, King of Prussia, PA
            </p>
            <p>
              <strong>Software Engineer</strong>, June 2018 - March 2019
            </p>
            <p>
              Technologies: C#, .NET Core, SQL, Angular, Scrum, Agile, Postman,
              PostgreSQL
            </p>
            <p>
              Designed, developed, documented, tested, and debugged software that
              contained logical and mathematical solutions to business/mission
              problems or questions. Ensured software standards were met.
            </p>
            <ul>
              <li>
                Utilized C# and .NET Core to create RESTful microservice APIs that
                communicated with a PostgreSQL database.
              </li>
              <li>
                Utilized Angular to create GUIs to test functionality of
                microservices
              </li>
            </ul>
            <p>
              <strong>West Chester University</strong>, West Chester, PA
            </p>
            <p>
              <strong>Web Team Intern</strong>, September 2015 - June 2018
            </p>
            <p>
            Technologies: C#, ASP.NET, JavaScript, JQuery, MySQL, HTML, CSS
            </p>
            <p>
            Enhanced pages with JavaScript, and ASP.Net/C# forms and integrated data flows with the support of MySQL databases. Engaged with clients to gather requirements for web page and form design projects while maintaining security and compliance.
            </p>
            <ul>
              <li>
                Spearheaded the optimization of a calendar system for use across the entire university website.
              </li>
              <li>
                Designed site-wide regular expression system now fully utilized by all team members and staff.
              </li>
            </ul>
          </div>
          </div>
          <div className="grid-2"></div>
        </CenterMiddleSection>
      </div>
    );
  }
}
