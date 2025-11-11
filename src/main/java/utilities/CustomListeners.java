package utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomListeners implements ITestListener {

    private static final Logger log = LoggerFactory.getLogger(CustomListeners.class);

    //execute before starting of test set/batch
    public void onStart(ITestContext arg) {
        log.info("Test execution is started :{}", arg.getName());
    }

    //execute after starting of test set/batch
    public void onFinish(ITestContext arg) {
        log.info("Test execution is finished :{}" , arg.getName());
    }

    //execute before main test start i.e. @Test
    public void onTestStart(ITestResult arg0) {
        log.info("Test is started :{}" , arg0.getName());
    }

    //execute when test is skipped
    public void onTestSkipped(ITestResult arg0) {
        log.info("Test is skipped :{}" , arg0.getName());
    }

    //execute when test is passed
    public void onTestSuccess(ITestResult arg0) {
        log.info("Test is passed :{}" , arg0.getName());
    }

    //execute when test is failed
    public void onTestFailure(ITestResult arg0) {
        log.info("Test is failed :{}" , arg0.getName());
    }

}

