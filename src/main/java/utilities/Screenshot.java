package utilities;

import base.BasePage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Screenshot extends BasePage{

    //WebDriver driver;

    public Screenshot(WebDriver driver) {
        super(driver);
    }


    public String captureScreen(String testName) throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        TakesScreenshot takesScreenshot=(TakesScreenshot) driver;
        File sourceFile = (takesScreenshot.getScreenshotAs(OutputType.FILE));
        String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + testName + "_" + timeStamp + ".png";
        File targetFile=new File(targetFilePath);

        //sourceFile.renameTo(targetFile);
        Files.copy(sourceFile.toPath(), targetFile.toPath());
        return targetFilePath;
    }
}
