package hellocucumber;


import hellocucumber.Pages.InventoryItemPage;
import hellocucumber.Pages.InventoryPage;
import hellocucumber.Pages.LoginPage;
import hellocucumber.Pages.ShoppingCartPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class StepDefinitions {

    static WebDriver driver;
    static String currentURL = "";
    static WebDriverWait wait;
    static InventoryPage inventoryPage;
    static LoginPage loginPage;
///////////////////////LOGIN//////////////////////

    @Given("I am on the Login Page of Sauce demo")
    public void i_am_on_the_login_page_of_sauce_demo() {
        // Write code here that turns the phrase above into concrete actions
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/index.html");

    }


    @When("I enter valid username and password")
    public void i_enter_valid_username_and_password() {
        // Write code here that turns the phrase above into concrete actions
        loginPage= new LoginPage(driver);
        loginPage.setUserName("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();

    }

    @Then("I should be taken to Inventory Page")
    public void i_should_be_taken_to_inventory_page() {
        // Write code here that turns the phrase above into concrete actions
        currentURL = loginPage.getDriver().getCurrentUrl();
        assertEquals("https://www.saucedemo.com/inventory.html", currentURL); // Confirms that we have successfully Loged in.
    }

    //////////////////////SELECT FIRST ITEM////////////////////


    @Given("I am on the Inventory Page of Sauce demo")
    public void i_am_on_the_inventory_page_of_sauce_demo() {
        inventoryPage= new InventoryPage(driver);
        currentURL = inventoryPage.getDriver().getCurrentUrl();
        assertEquals("https://www.saucedemo.com/inventory.html", currentURL);

    }

    @When("I select first item on the list")
    public void i_select_first_item_on_the_list() {

        List<WebElement> products = inventoryPage.getProductNameLinks();
        products.get(0).click();// Click First Item.

    }

    @Then("I am on the item Page Succesfully")
    public void i_am_on_the_item_page_succesfully() {
        currentURL = driver.getCurrentUrl();
        assertEquals("https://www.saucedemo.com/inventory-item.html?id=4", currentURL); // CHECK IF WE ARE ON CORRECT PAGE !

    }

    //////////////////////ADDD ITEM TO SHOPPING CART////////////////////////

    @Given("I am on the Item Page of source demo")
    public void i_am_on_the_item_page_of_source_demo() {
        wait = new WebDriverWait(driver, 10);
        // Write code here that turns the phrase above into concrete actions
        currentURL = driver.getCurrentUrl();
        assertEquals("https://www.saucedemo.com/inventory-item.html?id=4", currentURL); // CHECK IF WE ARE ON CORRECT PAGE !

    }

    @When("I click addToCart Button")
    public void i_click_add_to_cart_button() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btn_primary btn_inventory")));
        InventoryItemPage inventoryItemPage = new InventoryItemPage(driver);
        inventoryItemPage.addCartButtonClick();

    }

    @Then("Added succesfully")
    public void added_succesfully() {
        // Write code here that turns the phrase above into concrete actions
        WebElement addToCartButton = driver.findElement(By.xpath("//*[contains(@class,'btn_primary btn_inventory')]"));
        String nameChecker = addToCartButton.getText();
        assertEquals("REMOVE", nameChecker); // If the Text on the button is 'REMOVE' So means that it added successsfully.
        //SoftAssert'te kullanılabilir.

    }

    ////////////////////////////GO TO SHOPPING CART//////////////////////////////////////
    @Given("I have succesfully add Item to ShoppingCart")
    public void i_have_succesfully_add_item_to_shopping_cart() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("shopping_cart_container")));
        // Write code here that turns the phrase above into concrete actions
        try {
            WebElement cartButtonBadge = driver.findElement(By.xpath("//*[contains(@class,'fa-layers-counter shopping_cart_badge')]")); // means there is badge
        } catch (NotFoundException e) {
            throw new NotFoundException("Not Founded");
        }

    }

    @When("I click ShoppingCart button")
    public void i_click_shopping_cart_button() {
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        shoppingCartPage.getClass();
        shoppingCartPage.clickCheckoutButton();

    }

    @Then("I should be in ShoppingCart Page")
    public void i_should_be_in_shopping_cart_page() {
        // Write code here that turns the phrase above into concrete actions
        currentURL = driver.getCurrentUrl();
        assertEquals("https://www.saucedemo.com/cart.html", currentURL);

    }

}


