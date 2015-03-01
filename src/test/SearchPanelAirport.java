package test;

import org.testng.Assert;
import org.testng.annotations.*;
import pageobject.SearchPage;


public class SearchPanelAirport extends BasicTestCase {
    public String defaultQuestionAirport = "Von welchem Flughafen möchten Sie abfliegen?";
    public String germanyFlightDestination = "Nord Sud Ost West";
    public String airportDestinationCountry = "Deutschland Osterreich Schweiz Sonstige";

    public String defaultTextInAiroportFieldAfterAction = "Alle";
    public String defaultTextInAiroportFieldBeforeAction = "Von wo?";

    public String germanyFlightCitiesByDefault = "Altenburg-Nobitz Berlin-Schonefeld Berlin-Tegel Bremen Dortmund Dresden Dusseldorf Erfurt Frankfurt Frankfurt-Hahn Friedrichshafen Hamburg Hannover Karlsruhe Koln-Bonn Leipzig/Halle Lubeck Memmingen Munchen Munster-Osnabruck Niederrhein (Weeze) Nurnberg Paderborn Rostock Saarbrucken Schwerin Stuttgart Zweibrucken";
    public String austriaFlightCitiesByDefault = "Graz (A) Innsbruck (A) Klagenfurt (A) Linz (A) Salzburg (A) Wien (A)";
    public String switzerlandFlightCitiesByDefault = "Basel-Mulhouse (CH) Genf (CH) Zürich (CH)";
    public String otherFlightCitiesByDefault = "Amsterdam (NL) Brussel (B) Eindhoven (NL) Enschede (NL) Groningen (NL) Luxemburg Luttich (B) Maastricht-Aachen (NL) Strasbourg (F) Warschau (PL)";

    @DataProvider
    public Object[][] citiesInAirportField() {

        return new Object[][]{
                {"BRE,HAM,HAJ,LBC,RLG,SZW", "FDH,FKB,FMM,MUC,NUE,STR", "AOC,SXF,TXL,DRS,ERF,LEJ,RLG,SZW", "DTM,DUS,FRA,HHN,CGN,FMO,NRN,PAD,SCN,ZQW",
                        "GRZ,INN,KLU,LNZ,SZG,VIE", "BSL,GVA,ZRH", "AMS,BRU,EIN,ENS,GRQ,LUX,LGG,MST,SXB,WAW"}
        };
    }

    @Test(dataProvider = "citiesInAirportField")
    public void testSearch(String germanyDestinationNorth, String germanyDestinationSouth, String germanyDestinationEast, String germanyDestinationWest,
                           String austriaAllCities, String switzerlandAllCities, String otherAllCities) throws Exception {

        SearchPage sp = new SearchPage(driver);

        //textInfieldAirportBeforeAction
        String textInfieldAirportBeforeAction = sp.fieldAirport.getAttribute("value");
        Assert.assertEquals(textInfieldAirportBeforeAction, defaultTextInAiroportFieldBeforeAction);

        //textQuestion
        sp.fieldAirport.click();
        String textQuestion = sp.questionText.getText();
        Assert.assertEquals(textQuestion, defaultQuestionAirport);

        //destinationCountries
        String destinationCountries = sp.destinationCountries.getText();
        Assert.assertEquals(destinationCountries.replace("\n", " ").replace("Ö", "O"), airportDestinationCountry);

        //checkbox allAirportsIsActive
        Assert.assertTrue(sp.allAirportIsActive.isSelected());

        //textInFieldAirportAfterActions;
        String textInFieldAirportAfterAction = sp.fieldAirport.getAttribute("value");
        Assert.assertEquals(textInFieldAirportAfterAction, defaultTextInAiroportFieldAfterAction);

        //citiesOnTabGermany;
        sp.citiesOnTabGermany.click();
        String namesGermanyCities = sp.namesAllGermanyCities.getText();
        Assert.assertEquals(namesGermanyCities.replace("\n", " ").replace("ü", "u").replace("ö", "o"), germanyFlightCitiesByDefault);

        //germanyFlightDestination;
        String germanyDestination = sp.germanyFlightDestination.getText();
        Assert.assertEquals(germanyDestination.replace("\n", " ").replace("ü", "u").replace("ö", "o"), germanyFlightDestination);

        //cities Germany North
        sp.citiesGermanyNorth.click();
        String citiesGermanyNorth = sp.fieldAirport.getAttribute("value");
        Assert.assertEquals(citiesGermanyNorth, germanyDestinationNorth);
        sp.citiesGermanyNorth.click();

        //cities Germany South
        sp.citiesGermanySouth.click();
        String citiesGermanySouth = sp.fieldAirport.getAttribute("value");
        Assert.assertEquals(citiesGermanySouth, germanyDestinationSouth);
        sp.citiesGermanySouth.click();

        //cities Germany East
        sp.citiesGermanyEast.click();
        String citiesGermanyEast = sp.fieldAirport.getAttribute("value");
        Assert.assertEquals(citiesGermanyEast, germanyDestinationEast);
        sp.citiesGermanyEast.click();

        //cities Germany West
        sp.citiesGermanyWest.click();
        String citiesGermanyWest = sp.fieldAirport.getAttribute("value");
        Assert.assertEquals(citiesGermanyWest, germanyDestinationWest);
        sp.citiesGermanyWest.click();

        //Austria
        // citiesOnTabAustria
        sp.citiesOnTabAustria.click();
        String namesAustriaCities = sp.namesAllAustriaCities.getText();
        Assert.assertEquals(namesAustriaCities.replace("\n", " ").replace("ü", "u").replace("ö", "o"), austriaFlightCitiesByDefault);

        //destination Austria
        sp.selectAllAustriaCities();
        String citiesDestinationAustria = sp.fieldAirport.getAttribute("value");
        Assert.assertEquals(citiesDestinationAustria, austriaAllCities);
        sp.selectAllAustriaCities();

        //Switzerland
        // citiesOnTabSwitzerland
        sp.citiesOnTabSwitzerland.click();
        String namesSwitzerlandCities = sp.namesAllSwitzerlandCities.getText();
        Assert.assertEquals(namesSwitzerlandCities.replace("\n", " "), switzerlandFlightCitiesByDefault);

        //destinationSwitzerland
        sp.selectAllSwitzerlandCities();
        String citiesDestinationSwitzerland = sp.fieldAirport.getAttribute("value");
        Assert.assertEquals(citiesDestinationSwitzerland, switzerlandAllCities);
        sp.selectAllSwitzerlandCities();

        //Other
        // citiesOnTabOther
        sp.сitiesOnTabOther.click();
        String namesOtherCities = sp.namesAllOtherCities.getText();
        Assert.assertEquals(namesOtherCities.replace("\n", " ").replace("ü", "u").replace("ö", "o"), otherFlightCitiesByDefault);

        //destinationOther
        sp.selectOtherCities();
        String citiesDestinationOther = sp.fieldAirport.getAttribute("value");
        Assert.assertEquals(citiesDestinationOther, otherAllCities);
        sp.selectOtherCities();

        //checkbox allAirportsIsActive
        Assert.assertTrue(sp.allAirportIsActive.isSelected());

        //textInFieldAirportAfterActions
        Assert.assertEquals(textInFieldAirportAfterAction, defaultTextInAiroportFieldAfterAction);

    }

}
