package com.ui.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.ui.tests.BaseTest;
import com.utility.BrowserUtility;
import com.utility.ExtentReporterUtility;
import com.utility.LoggerUtility;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;

import java.util.Arrays;

@Listeners(com.ui.listeners.TestListener.class)
public class TestListener implements ITestListener {
    Logger logger = LoggerUtility.getLogger(this.getClass());


    @Override
    public void onTestStart(ITestResult result) {
        logger.info(result.getMethod().getMethodName());
        logger.info(result.getMethod().getDescription());
        logger.info(Arrays.toString(result.getMethod().getGroups()));
       // extentTest = extentReports.createTest(result.getMethod().getMethodName());
        ExtentReporterUtility.createExtentTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info(result.getMethod().getMethodName()+" "+"PASSED");
        ExtentReporterUtility.getTest().log(Status.PASS,result.getMethod().getMethodName()+" "+"PASSED");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.error(result.getMethod().getMethodName()+" "+"FAILED");
        logger.error(result.getThrowable().getMessage());
        ExtentReporterUtility.getTest().log(Status.FAIL,result.getMethod().getMethodName()+" "+"FAILED");
        ExtentReporterUtility.getTest().log(Status.FAIL,result.getThrowable().getMessage());

        Object baseTestClass = result.getInstance();
        BrowserUtility browserUtility = ((BaseTest)baseTestClass).getInstance();
        
        logger.info("Capturing screenshot for failed test cases");
        String screenshotPath = browserUtility.takeScreenShot(result.getName());

        logger.info("attaching screenshot to html report");
        ExtentReporterUtility.getTest().addScreenCaptureFromPath(screenshotPath);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logger.warn(result.getMethod().getMethodName()+" "+"SKIPPED");
        ExtentReporterUtility.getTest().log(Status.SKIP,result.getMethod().getMethodName()+" "+"SKIPPED");
    }


    @Override
    public void onStart(ITestContext context) {
        logger.info("Test Suite Started");
        ExtentReporterUtility.setUpSparkReporter("report.html");
    }

    @Override
    public void onFinish(ITestContext context) {
        logger.info("Test Suite Completed");
        ExtentReporterUtility.flushReport();
    }

}
