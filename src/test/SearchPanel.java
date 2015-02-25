package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.*;
import pageobject.SearchPage;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

/**
 * Created by Eugene on 2/21/2015.
 */
public class SearchPanel{
    public String defaultQuestionAirport = "Von welchem Flughafen möchten Sie abfliegen?";
    public String germanyFlightDestination = "Nord Sud Ost West";
    public String airportDestinationCountry = "Deutschland Osterreich Schweiz Sonstige";

    public String defaultTextInAiroportFieldAfterAction = "Alle";
    public String defaultTextInAiroportFieldBeforeAction = "Von wo?";

    public String germanyFlightCitiesByDefault = "Altenburg-Nobitz Berlin-Schonefeld Berlin-Tegel Bremen Dortmund Dresden Dusseldorf Erfurt Frankfurt Frankfurt-Hahn Friedrichshafen Hamburg Hannover Karlsruhe Koln-Bonn Leipzig/Halle Lubeck Memmingen Munchen Munster-Osnabruck Niederrhein (Weeze) Nurnberg Paderborn Rostock Saarbrucken Schwerin Stuttgart Zweibrucken";
    public String austriaFlightCitiesByDefault = "Graz (A) Innsbruck (A) Klagenfurt (A) Linz (A) Salzburg (A) Wien (A)";
    public String switzerlandFlightCitiesByDefault = "Basel-Mulhouse (CH) Genf (CH) Zürich (CH)";
    public String otherFlightCitiesByDefault = "Amsterdam (NL) Brussel (B) Eindhoven (NL) Enschede (NL) Groningen (NL) Luxemburg Luttich (B) Maastricht-Aachen (NL) Strasbourg (F) Warschau (PL)";

    public ChromeDriver driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");

        String STAGE = "http://www.thomascook.de";

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
        cap.setCapability(CapabilityType.PLATFORM, "WINDOWS");

        driver = new ChromeDriver(cap);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.navigate().to(STAGE);
     }

    @AfterTest
    public void tearDown()
    {
        driver.close();
    }

    @DataProvider
    public Object[][] citiesInAirportField() {
        return new Object[][]{
                {"BRE,HAM,HAJ,LBC,RLG,SZW", "FDH,FKB,FMM,MUC,NUE,STR", "AOC,SXF,TXL,DRS,ERF,LEJ,RLG,SZW", "DTM,DUS,FRA,HHN,CGN,FMO,NRN,PAD,SCN,ZQW",
                "GRZ,INN,KLU,LNZ,SZG,VIE", "BSL,GVA,ZRH", "AMS,BRU,EIN,ENS,GRQ,LUX,LGG,MST,SXB,WAW"}
        };
    }

    @Test(dataProvider = "citiesInAirportField")
    public void testSearch(String germanyDestinationNorth, String germanyDestinationSouth, String germanyDestinationEast, String germanyDestinationWest,
                           String austriaAllCities, String switzerlandAllCities, String allOtherCities) throws Exception {

            SearchPage sp = new SearchPage(driver);

// Airport
            validateDefaultTextInAirport();
            sp.clickOnAirport();
            checkAiroportQuestionText();
            validateAirportDestinationCountry();
            checkboxAllAirportIsActive();
            defaultTextInAirportField();

// germany Airport
            citiesOnFlifhtTabGermany();
            germanyFlightDestination();
            sp.clickGermanyCitiesFlightNorth();

            checkCitiesDestinationInAirportField(germanyDestinationNorth);
            sp.clickGermanyCitiesFlightNorth();

            sp.clickGermanyCitiesFlightSouth();
            checkCitiesDestinationInAirportField(germanyDestinationSouth);
            sp.clickGermanyCitiesFlightSouth();

            sp.clickGermanyCitiesFlightEast();
            checkCitiesDestinationInAirportField(germanyDestinationEast);
            sp.clickGermanyCitiesFlightEast();

            sp.clickGermanyCitiesFlightWest();
            checkCitiesDestinationInAirportField(germanyDestinationWest);
            sp.clickGermanyCitiesFlightWest();

            checkCitiesOnFlifhtTabAustria();
            sp.selectAllAustriaCities();
            checkCitiesDestinationInAirportField(austriaAllCities);
            sp.selectAllAustriaCities();

            citiesOnFlifhtTabSwitzerland();
            sp.selectAllSwitzerlandCities();
            checkCitiesDestinationInAirportField(switzerlandAllCities);
            sp.selectAllSwitzerlandCities();

            citiesOnFlifhtTabOther();
            sp.selectOtherCities();
            checkCitiesDestinationInAirportField(allOtherCities);
            sp.selectOtherCities();

            checkboxAllAirportIsActive();
            defaultTextInAirportField();
    }

    private void checkCitiesDestinationInAirportField(String citiesDestination) {
        String citiesDest = driver.findElement(By.id("selectedAirports")).getAttribute("value");
        Assert.assertEquals(citiesDest, citiesDestination);
    }

    private void germanyFlightDestination() {
       String germanyDestination =  driver.findElement(By.cssSelector(".greyband.row")).getText();
       Assert.assertEquals(germanyDestination.replace("\n", " ").replace("ü", "u").replace("ö", "o"), germanyFlightDestination);
    }

    private void citiesOnFlifhtTabOther() {
        WebElement other = driver.findElement(By.cssSelector("a[href='#other']"));
        other.click();
        String otherCities = driver.findElement(By.xpath(".//*[@id='other']/div")).getText();;
        Assert.assertEquals(otherCities.replace("\n", " ").replace("ü", "u").replace("ö", "o"), otherFlightCitiesByDefault);
    }

    private void citiesOnFlifhtTabSwitzerland() {
        WebElement switzerland = driver.findElement(By.cssSelector("a[href='#switzerland']"));
        switzerland.click();
        String switzerlandCities = driver.findElement(By.xpath(".//*[@id='switzerland']/div")).getText();;
        Assert.assertEquals(switzerlandCities.replace("\n", " "), switzerlandFlightCitiesByDefault);
    }

    private void checkCitiesOnFlifhtTabAustria() {
        WebElement austria = driver.findElement(By.cssSelector("a[href='#austria']"));
        austria.click();
        String austriaCities = driver.findElement(By.xpath(".//*[@id='austria']/div")).getText();;
        Assert.assertEquals(austriaCities.replace("\n", " "), austriaFlightCitiesByDefault);
    }

    private void citiesOnFlifhtTabGermany() {
        WebElement germany = driver.findElement(By.cssSelector("a[href='#germany']"));
        germany.click();
        String germanyCities = driver.findElement(By.cssSelector(".row.mg-2.mg-lr0")).getText();;
        Assert.assertEquals(germanyCities.replace("\n", " ").replace("ü", "u").replace("ö", "o"), germanyFlightCitiesByDefault);
    }

    public void defaultTextInAirportField() {
        String defaultTextInAirportField  = driver.findElement(By.id("selectedAirports")).getAttribute("value");
        Assert.assertEquals(defaultTextInAirportField, defaultTextInAiroportFieldAfterAction);
    }

    private void checkboxAllAirportIsActive() {
        Assert.assertTrue(driver.findElement(By.id("allAirports")).isSelected());;
    }

    private void checkAiroportQuestionText() {
        String airportText = driver.findElement(By.xpath(".//*[@id='flightDropdown']//span[text()=\"Von welchem Flughafen möchten Sie abfliegen?\"]")).getText();
        Assert.assertEquals(airportText,  defaultQuestionAirport);
    }

    private void validateAirportDestinationCountry() {
        String airportDestinationCountry = driver.findElement(By.cssSelector("#flightsTab")).getText();;
        Assert.assertEquals(airportDestinationCountry.replace("\n", " ").replace("Ö", "O"), this.airportDestinationCountry);
    }
    private void validateDefaultTextInAirport() {
        String textInAirport = driver.findElement(By.id("selectedAirports")).getAttribute("value");
        Assert.assertEquals(textInAirport, defaultTextInAiroportFieldBeforeAction);
    }

}