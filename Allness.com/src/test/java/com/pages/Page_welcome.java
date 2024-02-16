package com.pages;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.util.Assert;

public class Page_welcome extends Basetest {

	public Page_welcome(WebDriver driver) {
		this.driver = driver;
	}

	public void login() throws InterruptedException {
		String title = driver.findElement(By.tagName(loc.getProperty("Taglink"))).getText();
		String exptitle = "Welcome to the Simple Travel Agency!";

		if (title.equalsIgnoreCase(exptitle)) {
			System.out.println("validated");
		}
		driver.findElement(By.linkText(loc.getProperty("Beachlink"))).click();
		System.out.println(driver.getCurrentUrl());

		driver.navigate().back();

	}

	public void departure_city() {
		WebElement departuredropdown = driver.findElement(By.xpath(loc.getProperty("departuredropdown")));

		Select sc = new Select(departuredropdown);
		sc.selectByValue("Mexico City");

	}

	public void destination_city() {
		WebElement destinationdropdown = driver.findElement(By.xpath(loc.getProperty("destinationdropdown")));

		Select sc1 = new Select(destinationdropdown);
		sc1.selectByValue("London");

		driver.findElement(By.className(loc.getProperty("findflight"))).click();

	}

	public void choose_flight() {

		driver.findElement(By.xpath(loc.getProperty("chooseflight"))).click();

		String x = driver.findElement(By.xpath(loc.getProperty("totalcost"))).getText();
		System.out.println(x);

		driver.findElement(By.xpath(loc.getProperty("purchaseflight"))).click();
	}

	public void validate_purchase() {

		WebElement PurchasePage = driver.findElement(By.cssSelector(loc.getProperty("purchasepage")));
		if (PurchasePage.isDisplayed()) {

			String x = PurchasePage.getText();
			System.out.println(x + "Displayed");
		} else {
			System.out.println("Not Displayed");
		}

	}
	public void ID_display() {
		System.out.println("THE ID IS"+  driver.findElement(By.xpath(loc.getProperty("ID"))).getText());
	}
}