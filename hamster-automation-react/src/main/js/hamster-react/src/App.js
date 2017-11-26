import React, { Component } from 'react';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import logo from './logo.svg';
import './App.css';
import NFlatButton from './components/NFlatButton';

class App extends Component {
  render() {
    return (
      <MuiThemeProvider>
        <NFlatButton id="clickMeButton" label="Click Me" />
      </MuiThemeProvider>
    );
  }
}

export default App;
