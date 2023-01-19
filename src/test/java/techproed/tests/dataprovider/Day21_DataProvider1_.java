package techproed.tests.dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Day21_DataProvider1_ {

    /*
        What is data provider?
        Data Provider is used to get list of data
        We can get data from external file such as excel or json files
        Data provider is an annotation of testNG
        I use data provider to get data such as credentials from external files like excel

        How do you get data in your testNG framework?
        In data provider method, I use @DataProvider annotation.
        In test method I give data provider method name or custom name in annotation parameters.

        Data Provider has two parameters
        1.name: It is used to give custom name for data provider
        2.parallel: It is used for parallel testing
    */
    @DataProvider(name = "my_smoke_data", parallel = true)
    public Object[][] customerData(){

        Object[][] customerCredentials = {
                                            {"sam.walker@bluerentalcars.com","c!fas_art"},
                                            {"kate.brown@bluerentalcars.com","tad1$Fas"},
                                            {"raj.khan@bluerentalcars.com","v7Hg_va^"},
                                            {"pam.raymond@bluerentalcars.com","Nga^g6!"}
        };

        return customerCredentials;
    }

    @Test(dataProvider = "my_smoke_data")
    public void dataProviderTest1(String username, String password){

        System.out.println("Username: " + username + " <==> Password: " + password);
    }

    @Test(dataProvider = "my_smoke_data")
    public void dataProviderTest2(String user, String pass){

        System.out.println("User: " + user + "<==> Pass: " + pass);
    }
}
