package hellocucumber.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InventoryItemPage {
    WebDriver driver;

    public InventoryItemPage(WebDriver browserDriver){
        driver = browserDriver;
    }

    public void addCartButtonClick(){
        WebElement addToCartButton = driver.findElement(By.xpath("//*[contains(@class,'btn_primary btn_inventory')]"));
        addToCartButton.click();
    }

    public void clickBackButton(){
        WebElement backButton = driver.findElement(By.className("inventory_details_back_button"));
        backButton.click();
    }
}
