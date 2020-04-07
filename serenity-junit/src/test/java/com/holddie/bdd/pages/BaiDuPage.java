package com.holddie.bdd.pages;


import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleContains;

@DefaultUrl("https://www.baidu.com/")
public class BaiDuPage extends PageObject {


	@FindBy(id = "su")
	WebElement search;

	public void searchFor(String keywords) {
		search.sendKeys(keywords, Keys.ENTER);
		waitFor(titleContains(keywords));
	}
}
