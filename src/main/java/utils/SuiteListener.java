package utils;



import base.BaseTest;
//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IAnnotationTransformer;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class SuiteListener implements ITestListener, IAnnotationTransformer {

//    public void onTestFailure(ITestResult result) {
//
//        // Will take screenshot on test case failure
//        String fileName = System.getProperty("user.dir") + File.separator + "screenshots" + File.separator + result.getMethod().getMethodName();
//        File tempFile = ((TakesScreenshot)BaseTest.driver).getScreenshotAs(OutputType.FILE);
//
//        try {
//            FileUtils.copyFile(tempFile, new File(fileName + ".png"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }

    // Will retry failed tests x amount of times indicated in RetryAnalyzer
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        annotation.setRetryAnalyzer(RetryAnalyzer.class);
    }

}
