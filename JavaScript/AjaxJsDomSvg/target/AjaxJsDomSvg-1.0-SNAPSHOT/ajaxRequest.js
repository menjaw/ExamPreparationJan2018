/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var map = document.getElementById("map");

//addEventListener der lytter efter "clik" på "map" <Div>
map.addEventListener("click", toScreen);

var prevSelection;

function toScreen(evt) {

    if (prevSelection != undefined) {

        //Reset country colour
        prevSelection.target.style = "fill:#c0c0c0";

    }

    //Get the ID of the selected/clicked/chosen Country
    var selection = evt.target.id;
    //Splits the country ID by the -
    var splitSelect = selection.split("-");

    prevSelection = evt;

    //Colour Country Red
    evt.target.style = "fill:#ff0000";


    getCountry(splitSelect[0]);

}


function getCountry(direction) {

    var infoBox = document.getElementById("countryInfoBox");

    //Step 2
    //If we want to use restcountries REST API
    var url = "http://restcountries.eu/rest/v1/alpha?codes=" + direction;

    //Use the proxy
  //var url = "/ExamPrep-4_RestAjaxJs/CountryProxy?cc=" + country;


    //Variable
    var conf = {
        //Property : Value
        method: 'get'
    };


    var promise = fetch(url, conf);

    promise.then(function (response) {

        return response.text();

    }).then(function (text) {

        //REMOVE // FOR PROXY: var country = JSON.parse(text);
        var direction = JSON.parse(text);

        infoBox.innerHTML =
                "<b>Country:</b> " + direction[0].name + "<br>" +
                "<b>Population:</b> " + direction[0].population + "<br>" +
                "<b>Area:</b> " + direction[0].area + "<br>" +
                "<b>Borders:</b> " + direction[0].borders.toString() + "<br>" +
                "<b>Languages:</b> " + direction[0].languages.toString() + "<br>"
                ;
    });

}







