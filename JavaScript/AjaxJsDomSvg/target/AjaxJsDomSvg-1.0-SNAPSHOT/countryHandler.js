/* 
 * ADD-EVENT-LISTENER TO ELEMENT 
 */
//1: få fat i elementets id (svg-delen)
const map = document.getElementById("map");

//2: add eventhandler (addeventListener("event type", function som rammes))
map.addEventListener("click", selectCountry);



let previousClick;
function selectCountry(click) {
    //3: hvis et land allerede er valgt
    if (previousClick !== undefined) {
        previousClick.target.style = "fill: #999";
    }

    //1: få fat i det valgte områdes id
    const selectedCountry = click.target.id;
    console.log(selectedCountry);

    const splitSelectedCountry = selectedCountry.split("-");

    previousClick = click;

    //2: farv det valgte område med en farve
    click.target.style = "fill:#222";

//kalder på getCountryInformation metoden som returnerer data om det valgte land
    getCountryInformation(splitSelectedCountry[0]);
}


function getCountryInformation(selected) {
    //1: få fat i elementets Id (info boksen)
    const countryInfoBox = document.getElementById("countryInfoBox");

    //2: restcountries REST-API
    const url = "http://restcountries.eu/rest/v1/alpha?codes=" + selected;

    //3: configuration variabel (Property: 'Value')
    const conf = {
        method: 'get'
    };

    //AJAX request (til at fetche JSON datawn)
    const promise = fetch(url, conf);

    promise.then(function (response) {
        return response.text();
    }).then(function (text) {
        const selected = JSON.parse(text);
        countryInfoBox.innerHTML =
                "Country: " + selected[0].name + "<br>" +
                "Population: " + selected[0].population + "<br>" +
                "Area: " + selected[0].area + "<br>";
    });
}
