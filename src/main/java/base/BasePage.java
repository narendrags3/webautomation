package base;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class BasePage {

    public WebDriver driver;
    public Logger log = LoggerFactory.getLogger(this.getClass());


    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
}
