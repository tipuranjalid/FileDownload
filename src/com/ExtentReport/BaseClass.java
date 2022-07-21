package com.ExtentReport;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
	static WebDriver driver;

	public WebDriver driverInstatiation() {
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.google.co.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		return driver;
	}

	
	public void tearDown() {
		driver.close();
	}
}
