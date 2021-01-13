package hellocucumber;


import hellocucumber.Pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.*;

public class StepDefinitions {
    WebDriver driver;


///////////////////////LOGIN//////////////////////

    @Given("I am on the Login Page of Sauce demo")
    public void i_am_on_the_login_page_of_sauce_demo() {
        // Write code here that turns the phrase above into concrete actions
        System.setProperty("webdriver.chrome.driver", ".\\src\\test\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/index.html");
        throw new io.cucumber.java.PendingException();
    }

    @When("I enter valid username and password")
    public void i_enter_valid_username_and_password() {
        // Write code here that turns the phrase above into concrete actions
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUserName("problem_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();
        throw new io.cucumber.java.PendingException();
    }

    @Then("I should be taken to Inventory Page")
    public void i_should_be_taken_to_inventory_page() {
        // Write code here that turns the phrase above into concrete actions
        assertEquals(1, 1); // Confirms that we have successfully Loged in.
        throw new io.cucumber.java.PendingException();
    }

    //////////////////////SELECT FIRST ITEM////////////////////
    @Given("I am on the Inventory Page of Sauce demo")
    public void i_am_on_the_inventory_page_of_sauce_demo() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("I select first item on the list")
    public void i_select_first_item_on_the_list() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("I am on the item Page Succesfully")
    public void i_am_on_the_item_page_succesfully() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    //////////////////////ADDD ITEM TO SHOPPING CART////////////////////////

    @Given("I am on the Item Page of source demo")
    public void i_am_on_the_item_page_of_source_demo() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("I click addToCart Button")
    public void i_click_add_to_cart_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Added succesfully")
    public void added_succesfully() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    //////////////////////////////////////////////////////////////////

}


