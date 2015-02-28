package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import utils.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by Eugene on 2/26/2015.
 */
public class BasicTestCase {

    protected WebDriver driver;

    public WebDriver getWebDriver() {
        String userAgent = Configurator.userAgent;

        switch (userAgent.toLowerCase()) {
            case "firefox":

                DesiredCapabilities cap1 = new DesiredCapabilities();
                cap1.setCapability(CapabilityType.BROWSER_NAME, "Firefox");
                cap1.setCapability(CapabilityType.PLATFORM, "WINDOWS");

                driver = new FirefoxDriver(cap1);
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                driver.manage().window().maximize();
                driver.navigate().to(Configurator.config.WebUrl);

                break;

            case "chrome":
                System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");

                DesiredCapabilities cap = new DesiredCapabilities();
                cap.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
                cap.setCapability(CapabilityType.PLATFORM, "WINDOWS");

                driver = new ChromeDriver(cap);
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                driver.manage().window().maximize();

                driver.navigate().to(Configurator.config.WebUrl);

            break;
        }
        return driver;
    }

    @BeforeClass
    @Parameters({"userAgent", "environment"})
    public void initializeUserAgentAndEnvironment(String userAgent, String environment) {
        Configurator.userAgent = userAgent;
        Configurator.environment = environment;
        Configurator.config = new EnvironmentConfiguration(environment);
        driver = getWebDriver();


    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        if (driver != null) driver.quit();
    }

}



