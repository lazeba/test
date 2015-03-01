package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends Page{
    public WebDriver driver;

    public SearchPage(WebDriver driver) {
         super(driver);
    }

    @FindBy(id = "selectedAirports")
    public WebElement fieldAirport;

    @FindBy(css = "#flightsTab")
    public WebElement destinationCountries;

    @FindBy(xpath = ".//*[@id='flightDropdown']//span[text()=\"Von welchem Flughafen möchten Sie abfliegen?\"]")
    public WebElement questionText;

    @FindBy(id = "allAirports")
    public WebElement allAirportIsActive;

    @FindBy(css = "a[href='#germany']")
    public WebElement citiesOnTabGermany;

    @FindBy(css = ".row.mg-2.mg-lr0")
    public WebElement namesAllGermanyCities;

    @FindBy(css = ".greyband.row")
    public WebElement germanyFlightDestination;

    @FindBy(css = "a[href='#austria']")
    public WebElement citiesOnTabAustria;

    @FindBy(xpath = ".//*[@id='austria']/div")
    public WebElement namesAllAustriaCities;

    @FindBy(css = "a[href='#other']")
    public WebElement сitiesOnTabOther;

    @FindBy(xpath = ".//*[@id='other']/div")
    public WebElement namesAllOtherCities;

    @FindBy(id = "FDH,FKB,FMM,MUC,NUE,STR,INN,BSL,LNZ,SXB,ZRH,SZG")
    public WebElement citiesGermanySouth;

    @FindBy(id = "BRE,HAM,HAJ,LBC,RLG,SZW")
    public WebElement citiesGermanyNorth;

    @FindBy(id = "AOC,SXF,TXL,DRS,ERF,LEJ,RLG,SZW")
    public WebElement citiesGermanyEast;

    @FindBy(id = "DTM,DUS,FRA,HHN,CGN,FMO,NRN,PAD,SCN,ZQW,ENS,LUX,MST")
    public WebElement citiesGermanyWest;

    @FindBy(id = "GRZ")
    public WebElement cityGrazAustria;

    @FindBy(id = "INN")
    public WebElement cityInnsbruckAustria;

    @FindBy(id = "KLU")
    public WebElement cityKlagenfurtAustria;

    @FindBy(id = "LNZ")
    public WebElement cityLinzAustria;

    @FindBy(id = "SZG")
    public WebElement citySalzburgAustria;

    @FindBy(id = "VIE")
    public WebElement cityWienAustria;

    @FindBy(css = "a[href='#switzerland']")
    public WebElement citiesOnTabSwitzerland;

    @FindBy(xpath = ".//*[@id='switzerland']/div")
    public WebElement namesAllSwitzerlandCities;

    @FindBy(id = "BSL")
    public WebElement cityBaselMulhouseSwitzerland;

    @FindBy(id = "GVA")
    public WebElement cityGenfSwitzerland;

    @FindBy(id = "ZRH")
    public WebElement cityZurichSwitzerland;

    @FindBy(id = "WAW")
    public WebElement cityWarschauOther;

    @FindBy(id = "SXB")
    public WebElement cityStrasbourgOther;

    @FindBy(id = "MST")
    public WebElement cityMaastrichtAachenOther;

    @FindBy(id = "LGG")
    public WebElement cityLuttichOther;

    @FindBy(id = "LUX")
    public WebElement cityLuxemburgOther;

    @FindBy(id = "GRQ")
    public WebElement cityGroningenOther;

    @FindBy(id = "ENS")
    public WebElement cityEnschedeOther;

    @FindBy(id = "EIN")
    public WebElement cityEindhovenOther;

    @FindBy(id = "AMS")
    public WebElement cityAmsterdamOther;

    @FindBy(id = "BRU")
    public WebElement cityBrussselOther;

    @FindBy(id = "submitLetsGo")
    public WebElement buttonLetsGo;

    public void selectAllSwitzerlandCities(){
        cityBaselMulhouseSwitzerland.click();
        cityGenfSwitzerland.click();
        cityZurichSwitzerland.click();
    }

    public void selectOtherCities() {
        cityAmsterdamOther.click();
        cityBrussselOther.click();
        cityEindhovenOther.click();
        cityEnschedeOther.click();
        cityGroningenOther.click();
        cityLuxemburgOther.click();
        cityLuttichOther.click();
        cityMaastrichtAachenOther.click();
        cityStrasbourgOther.click();
        cityWarschauOther.click();
    }

    public void selectAllAustriaCities() {
        cityGrazAustria.click();
        cityInnsbruckAustria.click();
        cityKlagenfurtAustria.click();
        cityLinzAustria.click();
        citySalzburgAustria.click();
        cityWienAustria.click();
    }

//    @FindBy(id = "selectedAirports")
//    public WebElement selectedAirports;
}
