package com.automation.testcase;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.automation.base.DriverInstance;
import com.automation.pom.LoginPage;
import com.automation.utils.CaptureScreenshot;
import com.automation.utils.DataGenerator;
import com.automation.utils.PropertiesFileUtils;

public class TC_LoginTest extends DriverInstance {
	@Test(dataProvider = "Excel", dataProviderClass = DataGenerator.class)
	public void TC01_LoginFirstAccount(String email, String password, ITestResult result) throws IOException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driver.get(PropertiesFileUtils.getProperty("base_url"));
		LoginPage login = new LoginPage(driver);
		login.clickSigin();
		login.enterEmail(email);
		login.enterPassword(password);
		login.clickLogin();

		SoftAssert softAssert = new SoftAssert();
		String buttonLogoutLocated = PropertiesFileUtils.getProperty("icon_signout_xpath");

		try {
			WebElement buttonLogout = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(buttonLogoutLocated)));
			softAssert.assertEquals(true, buttonLogout.isDisplayed());
			buttonLogout.click();

		} catch (Exception e) {
			// TODO: handle exception
			CaptureScreenshot.takeScreenshot(driver, "Can_not_find_button_logout");
			softAssert.fail();
		}
		softAssert.assertAll();

	}
}
