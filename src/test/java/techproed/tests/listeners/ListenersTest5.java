package techproed.tests.listeners;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.utilities.Driver;

public class ListenersTest5 {

    // This test case FAILS
    // I will link this class to ListenersRetryAnalyzer
    // to run twice cause it fails
    // We will do this using xml files

    /*
We can add RETRY functionality in our testng framework using Listeners
The best way to connect test classes and retry functionality :
    1. Create ListenersRetry class
    package techproed.utilities;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
public class ListenersRetry implements IRetryAnalyzer {
//    This class is used to retry the failed test cases
    private int retryCount = 0;
    private static final int maxRetryCount = 1;
    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            return true;
        }
        return false;
}}
    2. Create ListenersRetryAnalyzer
    package techproed.utilities;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
public class ListenersRetryAnalyzer implements IAnnotationTransformer {
//    This is used to to automatically trigger the ListenersRetry class
//    So that the failed test case automatically will be run 3 times
    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        annotation.setRetryAnalyzer(ListenersRetry.class);
    }
}
3. Use xml file to link test cases and ListenersRetryAnalyzer
    <listeners>
        <listener class-name="techproed.utilities.ListenersRetryAnalyzer"></listener>
    </listeners>
 */
    @Test
    public void test1(){
        Driver.getDriver().get("https://techproeducation.com/");
        Assert.assertTrue(false);
    }
}

