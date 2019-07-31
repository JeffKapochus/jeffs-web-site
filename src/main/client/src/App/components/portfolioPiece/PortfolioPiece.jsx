import React from "react";
import {Link} from "react-router-dom"
import './PortfolioPiece.css'

export class PortfolioPiece extends React.Component {
  render() {
    return (
      <div className="portfolioPiece">
        <Link to={this.props.url} target="_blank" rel="noopener noreferrer">
          <img className="portfolioImage" src={this.props.image} alt={this.props.title} />
          <p>{this.props.title}</p>
        </Link>
      </div>
    );
  }
}
