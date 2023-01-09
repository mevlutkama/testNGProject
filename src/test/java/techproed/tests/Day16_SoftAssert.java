package techproed.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Day16_SoftAssert {
    @Test
    public void softAssertTest(){
        SoftAssert softAssert = new SoftAssert();

        System.out.println("Line 11 Code");
        softAssert.assertEquals(3,5); // Fails
        System.out.println("Line 13 Code");
        softAssert.assertEquals("apple", "orange");// Fails
        System.out.println("Line 15 Code");
        softAssert.assertTrue(false);// Fails
        System.out.println("Line 17 Code");
        softAssert.assertAll();// Marking the test case as failed or passed
    }
}
