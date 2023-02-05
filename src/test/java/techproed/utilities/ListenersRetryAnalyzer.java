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

