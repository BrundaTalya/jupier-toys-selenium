package com.bts.app.utils;


import com.bts.app.helper.ConfigReader;
import com.bts.app.helper.DriverHelper;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class Hooks {

    private DriverHelper driverHelper;
    private WebDriver driver;
    private ConfigReader configReader;
    private Properties properties;


    @Before
    public void launchBrowser() {
        configReader = new ConfigReader();
        properties = configReader.readFromConfigFile();
        //String browserName = properties.getProperty("browser");
        String browserName = System.getProperty("Browser");
        driverHelper = new DriverHelper();
        driver= driverHelper.initDriver(browserName);
    }


    @After
    public void quitBrowser() {driver.quit();}


}