package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

/**
 * Created by Eugene on 2/26/2015.
 */
public class BasicTestCase {

    protected WebDriver driver;

    public String userAgent;

    public WebDriver getWebDriver(String userAgent) {

        switch (userAgent.toLowerCase()) {
            case "firefox":

                driver = new FirefoxDriver();
                break;

            case "chrome":
                System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");

                DesiredCapabilities cap = new DesiredCapabilities();
                cap.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
                cap.setCapability(CapabilityType.PLATFORM, "WINDOWS");

                driver = new ChromeDriver(cap);
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                driver.manage().window().maximize();

                driver.navigate().to("http://www.thomascook.de");

//            default:
//                driver = new ChromeDriver();
//                break;
        }
        return driver;
    }

    @BeforeClass
    @Parameters({"userAgent"})
    public void initializeAgent(String userAgent) {
        this.userAgent = userAgent;
        driver = getWebDriver(userAgent);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        if (driver != null) driver.quit();
    }

}



