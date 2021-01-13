package hellocucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"}, features = {"src/test/resources/hellocucumber/Login.feature",
        "src/test/resources/hellocucumber/SelectFirstItem.feature",
        "src/test/resources/hellocucumber/AddItemToCart.feature",
        "src/test/resources/hellocucumber/GoShoppingCart.feature",
        "src/test/resources/hellocucumber/CheckItemOnList.feature",
        "src/test/resources/hellocucumber/ProceedCheckout.feature",
        "src/test/resources/hellocucumber/CompleteCheckout.feature",
        "src/test/resources/hellocucumber/FinishCheckout.feature",
        "src/test/resources/hellocucumber/Logout.feature"})

public class RunCucumberTest {

}
