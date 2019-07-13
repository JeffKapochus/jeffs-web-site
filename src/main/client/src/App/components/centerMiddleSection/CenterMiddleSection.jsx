import React from "react";
import "./CenterMiddleSection.css";

export class CenterMiddleSection extends React.Component {
  render() {
    const holderStyle = {
      backgroundImage: 'url(' + this.props.backgroundImage + ')',
      backgroundRepeat: 'repeat',
      backgroundAttachment: 'fixed',
      color: this.props.textColor,
      textAlign: this.props.align,
    };
    return (
      <div class="tableHolder" style={holderStyle}>
        <div class="contentHolder">
          {this.props.children}
        </div>
      </div>
    );
  }
}
