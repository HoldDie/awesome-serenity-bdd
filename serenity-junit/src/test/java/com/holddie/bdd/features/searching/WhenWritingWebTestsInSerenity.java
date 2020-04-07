package com.holddie.bdd.features.searching;

import com.holddie.bdd.pages.BaiDuPage;
import jdk.nashorn.internal.ir.annotations.Ignore;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static net.thucydides.core.annotations.ClearCookiesPolicy.BeforeEachTest;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SerenityRunner.class)
public class WhenWritingWebTestsInSerenity {

	@Managed(uniqueSession = true, clearCookies = BeforeEachTest)
	WebDriver driver;

	BaiDuPage baiDuPage;

	@Test
	@Ignore
	public void shouldInstanceAWebDriverInstanceForAWebTest() {
		driver.get("https://www.baidu.com/");
		driver.findElement(By.id("su"));
		new WebDriverWait(driver, 5);
		assertThat(driver.getTitle()).contains("百度一下");
	}

	@Test
	@Pending
	public void shouldInstantiatedPageObjectsForAWebTest() {
		baiDuPage.open();
		baiDuPage.searchFor("百度一下");
		assertThat(baiDuPage.getTitle()).contains("百度一下");
	}

}
