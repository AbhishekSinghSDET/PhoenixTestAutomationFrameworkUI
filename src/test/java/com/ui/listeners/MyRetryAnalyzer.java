package com.ui.listeners;

import com.constants.Env;
import com.utility.PropertiesUtil;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import java.util.Properties;


public class MyRetryAnalyzer implements IRetryAnalyzer {
//This class is called only when the test fails

    private static final int MAX_NUMBER_OF_ATTEMPTS = Integer.parseInt(PropertiesUtil.readProperty(Env.QA,"MAX_NUMBER_OF_ATTEMPTS"));
    private int currentAttempt = 1;

    @Override
    public boolean retry(ITestResult iTestResult) {

        if (iTestResult.getStatus() == ITestResult.FAILURE) {
            if (currentAttempt < MAX_NUMBER_OF_ATTEMPTS) {
                currentAttempt++;
                return true;
            }
        }
        return false;
    }
}

