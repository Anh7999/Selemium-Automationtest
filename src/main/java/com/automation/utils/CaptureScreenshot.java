package com.automation.utils;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class CaptureScreenshot {
	static String filename = "qqq";
	
	public static void takeScreenshot(WebDriver driver, String imageName) throws IOException {
		try {
			File theDir = new File("./Screenshots");
			if (!theDir.exists()) {
				theDir.mkdirs();
			}
//			BufferedImage image = new Robot()
//					.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
			filename = "./Screenshots/" + imageName + ".png";
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			File f = screenshot.getScreenshotAs(OutputType.FILE);

			File fd = new File(filename);
			FileUtils.copyFile(f, fd);
		} catch (Exception e) {
			System.out.println("Da xay ra loi chup man hinh");
			e.printStackTrace();
		}
		attachScreebshotToReport();

	}
	public static void attachScreebshotToReport() throws IOException{
		try {
			System.setProperty("org.uncommons.reportng.escape-output", "false");
			File file = new File(filename);
			Reporter.log("<br><a title=\"Screenshot\" href=\"" + file.getAbsolutePath() + "\">" + "<img alt='"
					+ file.getName() + "'src='" + file + "'height='243' width='418'</a><br>");
		} catch (Exception e) {
			System.out.println("Da xay ra loi att man hinh");
			e.printStackTrace();
			// TODO: handle exception
		}

	}
}
