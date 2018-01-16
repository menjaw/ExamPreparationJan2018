/**
 * Created by Menja on 10-01-2018.
 */
import React, {Component} from 'react';
import {Link} from "react-router-dom";
import data from "./data.json";

class Userlist extends Component {

    constructor(props) {
        super(props);
        this.state = {
            isLoading: true,
            users: []
        }
    }

    componentWillMount() {
        this.getUsers();
    }

    getUsers() {
        fetch("https://jsonplaceholder.typicode.com/users")//fetch tager imod 1 argument (stien til ressourcen)
            .then(response => response.json())//returnerer en promise(ren tekst, objekt, array) og konventerere til json
            .then(parsedJSON => {
                console.log(parsedJSON);//viser data som json i console
                let users = parsedJSON.map((user) => {
                    return (
                        <div key={user.name}>
                            <p>{user.id}:
                                {user.name}</p>
                            <p><b>Username:</b> {user.username}</p>
                            <Link to={"/details?Id=" + user.id}>Details</Link>
                        </div>
                    )
                })
                this.setState({users: users});
                console.log("state:", this.state.users);
            })
            .catch(error => console.log('parsing failed', error))
    }


    render() {
        return (
            <div>
                <h1 className="App-title">Welcome to userlist</h1>
                <p>Testing the shit</p>
                {this.state.users}
                <Link to="/">Back</Link>
            </div>
        );
    }
}
export default Userlist;
