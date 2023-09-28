package com.bts.app.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = "src/test/Resources/features",
        glue = {"com.bts.app.stepdefinitions", "com/bts/app/utils"},
        plugin = {"pretty", "html:target/cucumber-reports.html", "json:target/cucumber.json",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        monochrome = true,
        publish = true)

public class TestRunner extends AbstractTestNGCucumberTests {


}
