package com.holddie.bdd.features;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
		features = "src/test/resources/features",
		glue = "com.holddie.bdd")
public class CashWithdrawalsTest {
}
