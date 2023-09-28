package com.bts.app.pages;

import com.bts.app.helper.ConfigReader;
import com.bts.app.helper.DriverHelper;
import com.bts.app.helper.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Properties;

public class HomePage {

    private WebDriver driver;
    private Properties properties;
    private ConfigReader configReader;

    private WaitHelper wait;

    private By contactPageButton = By.xpath("//*[@id='nav-contact']/a");
    private By shopPageButton = By.xpath("//*[@id='nav-shop']/a");


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToHomePage() {
        configReader = new ConfigReader();
        properties = configReader.readFromConfigFile();
        String projectURL = properties.getProperty("Url");
        DriverHelper.getDriver().get(projectURL);
        String pageTitle = getHomePageTitle();
        Assert.assertTrue(pageTitle.contains("Jupiter Toys"));
    }

    public String getHomePageTitle() {
        return driver.getTitle();
    }

    public ContactPage clickOnContactPage() {
        wait = new WaitHelper(driver);
        wait.waitForElement(contactPageButton);
        driver.findElement(contactPageButton).click();
        return new ContactPage(driver);
    }

    public ShopPage clickOnShopPage(){
        wait = new WaitHelper(driver);
        wait.waitForElement(shopPageButton);
        driver.findElement(shopPageButton).click();
        return new ShopPage(driver);
    }


}