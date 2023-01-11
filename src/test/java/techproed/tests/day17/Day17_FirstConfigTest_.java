package techproed.tests.day17;

import org.testng.annotations.Test;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

import static org.testng.AssertJUnit.assertEquals;

public class Day17_FirstConfigTest_ {

    @Test
    public void firstConfigTest(){

        // Go to techproed homepage
        Driver.getDriver().get(ConfigReader.getProperty("url_prod_techproed"));

        // assert title
        assertEquals(ConfigReader.getProperty("app_title"),Driver.getDriver().getTitle());

        Driver.closeDriver();
    }
}
