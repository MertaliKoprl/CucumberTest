package hellocucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;



@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"},features={"src/test/resources/hellocucumber/Login.feature","src/test/resources/hellocucumber/SelectFirstItem.feature"})
public class RunCucumberTest {

}
