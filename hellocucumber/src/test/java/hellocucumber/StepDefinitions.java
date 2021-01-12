package hellocucumber;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.*;

public class StepDefinitions {
    WebDriver driver;
    @Given("I am on the Login Page of Sauce demo")
    public void i_am_on_the_login_page_of_sauce_demo() {
        System.setProperty("webdriver.chrome.driver", ".\\src\\test\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/index.html");
        throw new io.cucumber.java.PendingException();
    }

    @When("I enter valid username and password")
    public void i_enter_valid_username_and_password() {
        assertEquals(1, 1);
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("I should be taken to Inventory Page")
    public void i_should_be_taken_to_inventory_page() {
        assertEquals(1, 1);
        throw new io.cucumber.java.PendingException();
    }
}


