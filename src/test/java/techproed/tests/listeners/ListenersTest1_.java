package techproed.tests.listeners;

import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

import static org.testng.AssertJUnit.assertTrue;

/*
    Use @Listeners annotation to connect test classes and listeners
    techproed.utilities.Listeners.class ==> path of listeners utility
 */

@Listeners(techproed.utilities.Listeners.class)
public class ListenersTest1_ {

    @Test
    public void test1(){
        System.out.println("This case 1 PASS");
        assertTrue(true);
    }

    @Test
    public void test2(){
        System.out.println("This case 2 FAIL");
        assertTrue(false);
    }

    @Test
    public void test3(){
        System.out.println("This case 3 SKIPPED");
        throw new SkipException("SKIP this test case");
    }

    @Test
    public void test4(){
        System.out.println("Test case 4 No Such Element Exception");
        Driver.getDriver().get(ConfigReader.getProperty("url_prod_techproed"));
        Driver.getDriver().findElement(By.id("abcd"));// No Such Element Exception
        Driver.closeDriver();
    }
}
