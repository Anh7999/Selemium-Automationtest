package com.automation.pom;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.utils.PropertiesFileUtils;

public class LoginPage {
	private WebDriver driver;
	private WebDriverWait wait;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	public void clickSigin() {
		String buttonSiginLocated = PropertiesFileUtils.getProperty("icon_sigin_xpath");
		WebElement buttonSigin = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(buttonSiginLocated)));
		buttonSigin.click();
	}

	public void enterEmail(String email) {
		String locatorEmail = PropertiesFileUtils.getProperty("login_email");
		WebElement inputEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorEmail)));
		inputEmail.sendKeys(email);
	}

	public void enterPassword(String password) {
		String locatorPassword = PropertiesFileUtils.getProperty("login_password");
		WebElement inputPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorPassword)));
		inputPassword.sendKeys(password);
	}

	public void clickLogin() {
		String buttonLoginLocated = PropertiesFileUtils.getProperty("login_button");
		WebElement buttonLogin = driver.findElement(By.xpath(buttonLoginLocated));
		buttonLogin.click();
	}



}
