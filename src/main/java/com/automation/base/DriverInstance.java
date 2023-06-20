package com.automation.base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import com.automation.utils.CaptureScreenshot;
import com.automation.utils.PropertiesFileUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverInstance {
	public WebDriver driver;

	@BeforeClass
	public void initDriverInstance() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void takeScreenshot(ITestResult result) throws IOException{
//		Thread.sleep(1000);

		if (ITestResult.FAILURE == result.getStatus()) {
			try {
				String email = (String) result.getParameters()[0];
				int index = email.indexOf("@");
				String accountName = email.substring(0, index);
				CaptureScreenshot.takeScreenshot(driver, accountName);
				System.out.println("Da chup man hinh: " + accountName);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Exception while taling screen shot" + e.getMessage());
			}
		}
	}

	@AfterClass
	public void closeDriverInstance() {
		driver.close();
	}
}
