package techproed.tests.day17;

import org.testng.annotations.Test;
import techproed.utilities.Driver;

public class Day17_FirstDriverTest_ {

    @Test
    public void firstDriverTest(){
        Driver.getDriver().get("https://techproeducation.com/");
        Driver.closeDriver();
    }
}
