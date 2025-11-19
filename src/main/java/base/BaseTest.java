package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {

    public WebDriver driver;
    public Properties p;

    @BeforeClass
    public void setup() throws IOException {
        FileReader file = new FileReader(System.getProperty("user.dir")+"\\src\\main\\resources\\Conf.Properties");
        p = new Properties();
        p.load(file);

        driver = new ChromeDriver();
        driver.get(p.getProperty("appURL"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterClass

    public void teardown() {
        driver.quit();
    }
}
