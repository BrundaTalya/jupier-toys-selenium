package com.bts.app.helper;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class WaitHelper {

    private WebDriver driver;

    public WaitHelper(WebDriver driver) {
        this.driver = driver;
    }


    public void waitForElement(By element, int seconds){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        }catch (org.openqa.selenium.NoSuchElementException | TimeoutException | StaleElementReferenceException e) {

            e.printStackTrace();
        }

    }

    public void waitForElementsList(By element, int seconds){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        try {
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(element));
        }catch (org.openqa.selenium.NoSuchElementException | TimeoutException | StaleElementReferenceException e) {

            e.printStackTrace();
        }

    }

    public void waitForElementClick(By element, int seconds){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
        }catch (org.openqa.selenium.NoSuchElementException | TimeoutException | StaleElementReferenceException e) {

            e.printStackTrace();
        }

    }

    public void waitForElementInvisible(By element, int seconds){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));

        wait.until(ExpectedConditions.invisibilityOfElementLocated(element));

    }

    public void waitForElement(By element){
        waitForElement(element, 70);
    }

    public void waitForElementInvisible(By element){ waitForElementInvisible(element, 50);}

    public void waitForElementsList(By element){
        waitForElementsList(element, 50);
    }

    public void waitForElementClick(By element){
        waitForElementClick(element, 70);
    }



}