package hellocucumber.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ShoppingCartPage {
    WebDriver driver;

    public ShoppingCartPage(WebDriver browserDriver){
        driver = browserDriver;
        WebElement shoppingCart = driver.findElement(By.xpath("//*[contains(@class,'svg-inline--fa fa-shopping-cart fa-w-18 fa-3x ')]"));
        shoppingCart.click();
    }

    public int getNumberOfItems(){
        List<WebElement> numberOfItems = driver.findElements(By.className("cart_item"));
        return numberOfItems.size();
    }

    public void clickCheckoutButton(){
        WebElement checkoutButton = driver.findElement(By.xpath("//*[@id='cart_contents_container']/div/div[2]/a[2]"));
        checkoutButton.click();
    }
}
