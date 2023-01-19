package techproed.utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {

    /*
        ITestListener is an interface
        We use this interface to customize testNG framework
        onStart, onFinish, onTestStart, onTestFinish, onTestSuccess, onTestFailure are special method names are used to listen the test methods.
        We especially use listeners for adding a special condition such as test pass, fail or skipped
     */

    @Override
    public void onStart(ITestContext context) {
        System.out.println("onStart - Execute once before all tests: " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("onFinish - Execute once after all tests: " + context.getName());
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("onTestStart - Execute once before each @Test: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("onTestSuccess - Execute after each passed @Test: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("onTestFailure - Execute after each failed @Test: " + result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("onTestSkipped - Execute after each skipped @Test: " + result.getName());
    }
}
