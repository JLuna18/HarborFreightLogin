package utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer{

    int count = 1;

    public boolean retry(ITestResult result) {

        // Will retry test 1 time on failure
        while(count < 1) {
            count++;
            return true;
        }

        return false;
    }

}
