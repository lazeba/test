package pageobject;

import org.openqa.selenium.WebDriver;

/**
 * Created by Eugene on 2/27/2015.
 */
public abstract class Page {

    protected WebDriver driver;

    public Page(WebDriver driver) {
        this.driver = driver;
    }
}
