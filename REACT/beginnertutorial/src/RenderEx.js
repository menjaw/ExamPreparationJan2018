/**
 * Created by Menja on 09-01-2018.
 */
import React, {Component} from 'react';
import logo from './logo.svg';
import './App.css';

/*1. en måde at render på */
const AppJsx = () => {
    return (
        <div>
            <img src={logo} className="App-logo" alt="logo"/>
            <h1 className="App-title">Welcome to React</h1>
            <p>Testing rendering with JSX</p>
        </div>
    );
}
//export default AppJsx;

/*2. en anden måde at render på*/
class RenderEx extends Component {
    render() {
        return (
            <div>
                <img src={logo} className="App-logo" alt="logo"/>
                <h1 className="App-title">Welcome to React</h1>
                <p>Testing rendering with AppClass</p>
            </div>
        );
    }
}
export default RenderEx;


/*3. en tredje måde at render på*/
export const AppComponent = () => {
    return (
        <div>
            <img src={logo} className="App-logo" alt="logo"/>
            <h1 className="App-title">Welcome to React</h1>
            <p>Testing rendering with JSX component</p>
        </div>
    );
}