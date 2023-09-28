package com.bts.app.helper;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DriverHelper {


    public WebDriver driver;

    public static ThreadLocal<WebDriver> ldriver = new ThreadLocal<>();

    public WebDriver initDriver(String browser) {

        System.out.println("Selected browser is:" + browser);

        if (driver == null) {
            switch (browser.toLowerCase()) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    ldriver.set(new ChromeDriver());
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    ldriver.set(new FirefoxDriver());
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    ldriver.set(new EdgeDriver());
                    break;
                default:
                    throw new RuntimeException("Unsupported browser: " + browser);
            }
            // Delete cookies
            getDriver().manage().deleteAllCookies();

            // Maximize the browser window
            getDriver().manage().window().maximize();
        }
        return getDriver();
    }

    //this method gets driver with ThreadLocal
    public static WebDriver getDriver() {
        return ldriver.get();
    }


}
