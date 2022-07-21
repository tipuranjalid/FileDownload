package com.FileDownload;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DownloadingFile {
	public void downloadFile(String downloadFilePath) {
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadFilePath);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver(options);

		driver.get("https://www.wisdomaxis.com/technology/software/data/for-reports/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.linkText("Orders-With Nulls.xlsx")).click();
//File downloadedFile=new File(downloadFilePath+"\\Orders-With Nulls.xlsx");	
//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		Thread.sleep(5000);
//Assert.assertTrue(downloadedFile.exists());
//		downloadedFile.delete();
		driver.close();
	}

	@Test
	public void downloadingFileInChrome() throws InterruptedException {
		String downloadFilePath = System.getProperty("user.dir");
		// Add check to delete the file if it already exists
		File downloadedFile = new File(downloadFilePath + "\\Orders-With Nulls.xlsx");
		System.out.println(downloadedFile.exists());
		if (downloadedFile.exists()) {
			downloadedFile.delete();
			System.out.println("Successfully deleted the existing file");
			downloadFile(downloadFilePath);
		} else {
			downloadFile(downloadFilePath);
		}

	}
}
