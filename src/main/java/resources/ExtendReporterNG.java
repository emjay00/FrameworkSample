package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import javax.swing.*;

public class ExtendReporterNG {
    static ExtentReports extent;
    public static ExtentReports getReport(){
        String path =System.getProperty("user.dir")+"\\reports\\index.html";
        System.out.println(System.getProperty("user.dir")+"\\reports\\index.html");
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Web Automation Result");
        reporter.config().setDocumentTitle("Test Results");

        extent =new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Manu Joseph");
        return extent;
    }
}
