package com.bts.app.pages;

import com.bts.app.helper.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShopPage {

    private WebDriver driver;
    private WaitHelper wait;

    // Find all product elements

    By productSelector = By.xpath("//*[contains(@class, 'product ng-scope')]");
    By cartPageButton = By.xpath("//*[@id='nav-cart']/a");

    public ShopPage(WebDriver driver) {
        this.driver = driver;
    }

    public Map<String, Object> addToCart(String productName, int quantity){
        Map<String, Object> productInfo = new HashMap<>();
        wait = new WaitHelper(driver);
        wait.waitForElementsList(productSelector);
        List<WebElement> productElements = driver.findElements(productSelector);


        for (WebElement productElement : productElements){
            String actualProductName = productElement.getText().split("\\$")[0].trim();

            if(actualProductName.equals(productName)){
                double price = Double.parseDouble(driver.findElement(By.xpath("//h4[text() = '" + actualProductName + "']/..//span")).getText().replace("$",""));
                for (int i=0; i< quantity; i++) {
                    driver.findElement(By.xpath("//h4[text() = '" + actualProductName + "']/..//a")).click();
                }
                productInfo.put("ProductName", actualProductName);
                productInfo.put("ProductPrice", price);
                productInfo.put("Quantity", quantity);
            }

        }
        return productInfo;
    }

    public CartPage clickOnCartPage() {
        wait = new WaitHelper(driver);
        wait.waitForElement(cartPageButton);
        driver.findElement(cartPageButton).click();
        return new CartPage(driver);
    }
}
