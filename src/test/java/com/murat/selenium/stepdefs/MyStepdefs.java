package com.murat.selenium.stepdefs;

import com.google.common.collect.Ordering;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static com.murat.selenium.stepdefs.Hooks.driver;

/**
 * Copyright 2016 MuratKus
 * Part of GoEuro-Task
 * Created by kusm on 24/10/2016.
 */
public class MyStepdefs {

    @Given("^I navigated to \"([^\"]*)\"$")
    public void iNavigatedTo(String arg0) throws Throwable {
        driver.get(arg0);
    }

    @And("^I select \"([^\"]*)\" as from and \"([^\"]*)\" as destination$")
    public void iSelectAsFromAndAsDestination(String arg0, String arg1) throws Throwable {
        driver.findElement(By.id("from_filter")).sendKeys(arg0);
        driver.findElement(By.id("to_filter")).sendKeys(arg1);
    }

    @And("^I search$")
    public void iSearch() throws Throwable {
        while (existsElement("search-form__submit-btn")) {
            driver.findElement(By.id("search-form__submit-btn")).click();
            Thread.sleep(500);
        }
    }

    @And("^Select the \"([^\"]*)\" tab$")
    public void selectTheTab(String arg0) throws Throwable {
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));   //driver selects the newly opened tab, we have to switch to it o/w fails
        driver.findElement(By.id("tab_" + arg0)).click();
    }

    @Then("^I should view ordered \"([^\"]*)\" results$")
    public void iShouldViewOrderedResults(String arg0) throws Throwable {
        List<Integer> prices = new ArrayList<>();
        List<WebElement> results = driver.findElement(By.id("results-"+ arg0)).findElements(By.className("price-no"));
        for (WebElement result : results) {
            prices.add(Integer.parseInt(result.findElement(By.className("currency-beforecomma")).getText() +
            result.findElements(By.className("currency-decimals")).get(1).getText().trim())); //add the prices to a list to see ordering
        }
        if (!Ordering.natural().isOrdered(prices)) //if list items are not ordered.
            Assert.fail("LIST ITEMS ARE NOT ORDERED");
    }


    private boolean existsElement(String id) {
        try {
            driver.findElement(By.id(id));
        } catch (NoSuchElementException e) {
            return false;
        }
            return true;
        }


}
