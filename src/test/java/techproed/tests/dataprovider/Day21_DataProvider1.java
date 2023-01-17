package techproed.tests.dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Day21_DataProvider1 {

    /*
        What is data provider?
        Data provider is used to get list of data
        We can get data from external files, such as excel or json files
        DataProvider is an annotation of testNG
        I use Data Provider to get data such as credentials from excel sheet

        How to you get data in your testNG framework?
        In Data Provider method, I use @DataProvider annotation, in Test method I give the method name in the parameter

        Data Provider has 2 parameters:
        1.name: Used to give custom name for Data Provider.    @DataProvider(name = "my_smoke_data")
        2.parallel: Used to do parallel testing. Default is parallel = false. We can make parallel = true
     */

    // Data Provider Method
    @DataProvider(name = "my_smoke_data", parallel = true)
    public Object[][] customerData(){

        // Test Data
        Object [][] customerCredentials = {
                {"sam.walker@bluerentalcars.com", "c!fas_art"},
                {"kate.brown@bluerentalcars.com", "tad1$Fas"},
                {"raj.khan@bluerentalcars.com", "v7Hg_va^"},
                {"pam.raymond@bluerentalcars.com", "Nga^g6!"}
        };
        return customerCredentials;
    }

    // Test Method 1
    @Test(dataProvider = "my_smoke_data")
    public void dataProviderTest1(String username, String password){
        System.out.println("USERNAME: " + username + " | PASSWORD: " + password);
    }

    // Test Method 2
    @Test(dataProvider = "my_smoke_data")
    public void dataProviderTest2(String user, String pass){
        System.out.println(user + " | " + pass);
    }
}
