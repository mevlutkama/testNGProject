package techproed.tests.day16;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Day16_DependsOnMethods {

    @Test
    public void homePage(){
        System.out.println("I am on the home page");
    }

    @Test(dependsOnMethods = "homePage")
    public void searchPage(){
        System.out.println("I am on the search page");
        // Assert.assertTrue(false);
    }

    /*
        dependsOnMethods = "searchPage" -> Connecting checkOutPage to seaarchPage
        searchPage will execute right before checkOutPage
        If searchPage PASS -> execute checkoutPage
        If searchPage FAIL -> Skip checkoutPage
     */

    @Test(dependsOnMethods = "searchPage")
    public void checkOutPage(){
        System.out.println("I am on the checkout page");
    }
}
