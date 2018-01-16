/**
 * Created by Menja on 09-01-2018.
 */
import React from 'react';
import ReactDOM from 'react-dom';

const Headline = (props) => {
    const {title} = props; //gemmer prop som variabel og slipper for at skrive props.title i <h1>-tag
    return <div>
        <h1>{title}</h1>
        <p> Welcome to React World</p>
    </div>
}

const Greetings = (props) => {
    return <div>
        <p>With more time you will love it <b>{props.firstName} ({props.age} years old)</b></p>
        <h4>But it will at least take you about {props.time} to be able to do something really cool</h4>
        <p>Yoe have {props.eyecolor}</p>
    </div>
}

const Footer = (props) => {
    return <h1>This is footer and it is living at {props.address}</h1>
}

export const Page = () => {
    return (
        <div>
            <Headline title="Breaking News"/>
            <Greetings firstName="Menja" age={40} time="200 years" eyecolor="blue"/>
            <Footer address="Toftegårdsvej 33"/>
        </div>
    )
}


// /*VALIDATION - VIRKER IKKE*/
// Greeting.propTypes = {
//     name: React.Prop-types.string.isRequired ,
//     age: React.PropTypes.number,
//     time: React.PropTypes.string
// }