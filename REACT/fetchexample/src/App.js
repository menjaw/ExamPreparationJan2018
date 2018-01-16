import React, {Component} from 'react';
import logo from './logo.svg';
import './App.css';

class App extends Component {
    constructor(props) {
        super(props);
        this.state = {
            isLoading: true,
            labels: []
        }
    }

    componentWillMount() {
        this.getLabels();
        this.getCountries();
    }

    getLabels() {
        fetch("http://localhost:3333/labels")//fetch tager imod 1 argument (stien til ressourcen)
            .then(response => response.json())//returnerer en promise(ren tekst, objekt, array) og konventerere til json
            .then(parsedJSON => console.log(parsedJSON))
            .catch(error => console.log('parsing failed', error))
    }

    getCountries() {
        fetch("http://localhost:3333/countries")//fetch tager imod 1 argument (stien til ressourcen)
            .then(response => response.json())//returnerer en promise(ren tekst, objekt, array) og konventerere til json
            .then(parsedJSON => parsedJSON.map(countries => (
                {
                    name: `${countries.name}`,
                    population: `${countries.population}`
                }
            )))
            .then(countries => this.setState({
                countries,
                isLoading: false
            }))
            .catch(error => console.log('parsing failed', error))
    }

    render() {
        const {isLoading, countries} = this.state;
        return <div>

            <td>{countries.name}</td>
            <td>{countries.population}</td>

        </div>
    );
}

export default App;
