/**
 * Created by Menja on 10-01-2018.
 */
import React, {Component} from 'react';
import {Link} from "react-router-dom";

export const Hallo = () => {
    return <div>
        <h1>Welcome to DETAILS</h1>
        <Link to="/">Home</Link>
        <p></p>
        <Link to="/all">Back</Link>
    </div>
}