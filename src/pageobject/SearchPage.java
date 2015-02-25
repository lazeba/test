package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class SearchPage {
    public WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setNewDestinationCountry(String country) throws Exception {
        WebElement countryNew = driver.findElement(By.id("autoSuggestText"));
        countryNew.clear();
        countryNew.sendKeys(country);
    }

    public void clickOnPackageTab() throws InterruptedException {
        WebElement packageTab = driver.findElement(By.id("packageTab"));
        packageTab.click();
    }

    public void clickOnDestination() throws InterruptedException {
        WebElement destination = driver.findElement(By.id("autoSuggestText"));
        destination.click();
    }

    public void setDestinationCountry() {
        WebElement country = driver.findElement(By.cssSelector("div#tone div label[data-id=\"616\"]"));
        country.click();
    }

    public void clickOnAirport() throws InterruptedException {
        WebElement airport = driver.findElement(By.id("selectedAirports"));
        airport.click();
    }

    public void clickGermanyCitiesFlightSouth() {
        driver.findElement(By.id("FDH,FKB,FMM,MUC,NUE,STR,INN,BSL,LNZ,SXB,ZRH,SZG")).click();
    }

    public void clickGermanyCitiesFlightNorth() {
        driver.findElement(By.id("BRE,HAM,HAJ,LBC,RLG,SZW")).click();
    }

    public void clickGermanyCitiesFlightEast() {
        driver.findElement(By.id("AOC,SXF,TXL,DRS,ERF,LEJ,RLG,SZW")).click();
    }

    public void clickGermanyCitiesFlightWest() {
        driver.findElement(By.id("DTM,DUS,FRA,HHN,CGN,FMO,NRN,PAD,SCN,ZQW,ENS,LUX,MST")).click();
    }

    public void selectAllAustriaCities() {
        driver.findElement(By.id("GRZ")).click();
        driver.findElement(By.id("INN")).click();
        driver.findElement(By.id("KLU")).click();
        driver.findElement(By.id("LNZ")).click();
        driver.findElement(By.id("SZG")).click();
        driver.findElement(By.id("VIE")).click();
    }

    public void selectAllSwitzerlandCities() {
        driver.findElement(By.id("BSL")).click();
        driver.findElement(By.id("GVA")).click();
        driver.findElement(By.id("ZRH")).click();

    }

    public void selectOtherCities() {
        driver.findElement(By.id("AMS")).click();
        driver.findElement(By.id("BRU")).click();
        driver.findElement(By.id("EIN")).click();
        driver.findElement(By.id("ENS")).click();
        driver.findElement(By.id("GRQ")).click();
        driver.findElement(By.id("LUX")).click();
        driver.findElement(By.id("LGG")).click();
        driver.findElement(By.id("MST")).click();
        driver.findElement(By.id("SXB")).click();
        driver.findElement(By.id("WAW")).click();
    }

}
