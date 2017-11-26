import React, { Component } from 'react'
import FlatButton from 'material-ui/FlatButton'

class NFlatButton extends FlatButton {
  render() {
    return <FlatButton data-ntype="NFlatButton" {...this.props} />
  }
}

export default NFlatButton
