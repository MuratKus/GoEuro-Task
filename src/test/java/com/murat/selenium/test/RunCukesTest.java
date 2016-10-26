package com.murat.selenium.test;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


/**
 * Copyright 2016 MuratKus
 * Part of GoEuro-Task
 * Created by kusm on 24/10/2016.
 */

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = "json:target/cucumber.json",
        glue = {"com.murat.selenium.stepdefs"},
        features = {"classpath:features"},
        tags = {"~@ignore", "@wip"})
public class RunCukesTest {


}
