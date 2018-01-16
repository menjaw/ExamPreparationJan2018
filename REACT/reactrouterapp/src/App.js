import React, {Component} from 'react';
import './App.css';
import {BrowserRouter as Router, Route, Link, Switch} from "react-router-dom";
import Userlist from "./Userlist";
import {Hallo} from "./Details";

const Greeting = () => {
    return <div>
        <h1>Welcome to our friends site</h1>
        <Link to="/">Home</Link>
        <p></p>
        <Link to="/all">Page for all users</Link>
    </div>
}

class App extends Component {
    render() {
        return (
            <div className="App">
                <Router>
                    <Switch>
                        <Route exact path="/" component={Greeting}/>
                        <Route path="/all" component={Userlist}/>
                        <Route path="/details" component={Hallo}/>
                    </Switch>
                </Router>
            </div>
        );
    }
}

export default App;
