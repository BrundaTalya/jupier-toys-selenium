package com.bts.app.helper;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;


public class DriverHelper {


    public WebDriver driver;

    public static ThreadLocal<WebDriver> ldriver = new ThreadLocal<>();

    public WebDriver initDriver(String browser) {

        System.out.println("Selected browser is:" + browser);

        if (driver == null) {
            switch (browser.toLowerCase()) {
                case "Chrome":
                    WebDriverManager.chromedriver().setup();
                    ldriver.set(new ChromeDriver());
                    break;
                case "Firefox":
                    WebDriverManager.firefoxdriver().setup();
                    ldriver.set(new FirefoxDriver());
                    break;
                case "Edge":
                    WebDriverManager.edgedriver().setup();
                    ldriver.set(new EdgeDriver());
                    break;
                case "Safari":
                    WebDriverManager.safaridriver().setup();
                    ldriver.set(new SafariDriver());
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
