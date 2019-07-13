import React from "react";
import './PortfolioPiece.css'

export class PortfolioPiece extends React.Component {
  render() {
    return (
      <div className="portfolioPiece">
        <a href={this.props.url} target="_blank" rel="noopener noreferrer">
          <img className="portfolioImage" src={this.props.image} alt={this.props.title} />
          <p>{this.props.title}</p>
        </a>
      </div>
    );
  }
}
