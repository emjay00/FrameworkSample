package pageObjects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import resources.Base;
import resources.ExtendReporterNG;


public class CListeners extends Base implements ITestListener {

    ExtentReports extent = ExtendReporterNG.getReport();
    ExtentTest test;
    ThreadLocal extentTest = new ThreadLocal<ExtentTest>();


    public void onTestStart(ITestResult result) {
        //ITestListener.super.onTestStart(result);
        test = extent.createTest("Demo");
        System.out.println("inside listener");
        extentTest.set(test);
    }

    public void onTestSuccess(ITestResult result) {
        //ITestListener.super.onTestSuccess(result);
        test.log(Status.PASS, "Test passed OO1");
    }

    public void onTestFailure(ITestResult result) {
        //ITestListener.super.onTestFailure(result);
        test.fail(result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
    }


    public void onFinish(ITestContext context) {
       // ITestListener.super.onFinish(context);
        extent.flush();
    }
}
