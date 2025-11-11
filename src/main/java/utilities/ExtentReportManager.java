package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportManager implements ITestListener {

    public static ExtentSparkReporter sparkReporter;
    public static ExtentReports extent;
    public ExtentTest test;
    //public static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    String repName;
    //WebDriver driver;

    @Override
    public void onStart(ITestContext testContext) {

        String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        repName="Test-Report-"+timeStamp+".html";

        sparkReporter=new ExtentSparkReporter(".\\reports\\"+ repName);

        sparkReporter.config().setDocumentTitle("WebAutomation Report");
        sparkReporter.config().setReportName("Functional Testing");
        sparkReporter.config().setTheme(Theme.DARK);

        extent=new ExtentReports();
        extent.attachReporter(sparkReporter);

        String os= testContext.getCurrentXmlTest().getParameter("os");
        extent.setSystemInfo("Operating System",os);

        String browser= testContext.getCurrentXmlTest().getParameter("browser");
        extent.setSystemInfo("Browser",browser);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test= extent.createTest(result.getTestClass().getName());
        test= test.assignCategory(result.getMethod().getGroups());
        test.log(Status.PASS,"Test case PASSED is :"+result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test= extent.createTest(result.getTestClass().getName());
        test= test.assignCategory(result.getMethod().getGroups());
        test.log(Status.FAIL,"Test case FAILED is :"+result.getName());
        test.log(Status.INFO,result.getThrowable().getMessage());
/*
        try {
            String imgPath = new Screenshot(driver).captureScreen(result.getName());
            test.addScreenCaptureFromPath(imgPath);
        } catch (IOException e1) {
            e1.printStackTrace();
        }

 */
    }


    @Override
    public void onTestSkipped(ITestResult result) {
        test= extent.createTest(result.getTestClass().getName());
        test= test.assignCategory(result.getMethod().getGroups());
        test.log(Status.SKIP,"Test case SKIPPED is :"+result.getName());
        test.log(Status.INFO,result.getThrowable().getMessage());
    }

    @Override
    public void onFinish(ITestContext testContext) {
        extent.flush();
    }
}
