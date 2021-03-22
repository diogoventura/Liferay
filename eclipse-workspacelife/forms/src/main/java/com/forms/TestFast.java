package com.forms;

import java.net.MalformedURLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestFast {
	WebDriver driver = new ChromeDriver();

	@Before
	private void setchorme() {
		System.setProperty("webdriver.ie.driver",
				"/forms/src/main/resources/chromedriver.exe");
		driver.get("https://forms.liferay.com/web/forms/shared/-/form/122548?p_p_state=pop_up&p_p_auth=aEyldgtX&_com_liferay_dynamic_data_mapping_form_web_portlet_DDMFormPortlet_languageId=en_US");

	}

	@After
	private void tearDown() throws Exception {
		driver.close();
	}

	@Test
	private void submitinvalid() throws MalformedURLException {
		// click
		WebElement submit = driver.findElement(By.xpath("//*[@id='submit']"));
		submit.click();

		// view a menssage
		if (driver.findElement(By.className("form-feedback-item help-block")) != null) {
			System.out.println("Passed");
		} else {
			System.out.println("Error");
		}
	}

	@Test
	private void submitvalid() throws MalformedURLException {

		// What is your name?
		WebElement name = driver.findElement(By.xpath(
				"//*[@id='_com_liferay_dynamic_data_mapping_form_web_portlet_DDMFormPortlet_ddm$$WhatIsYourName$xvDU8M3b$0$$en_US']"));
		name.sendKeys("Diogo Ventura De Alemida");

		// What is your name?
		WebElement bird = driver
				.findElement(By.xpath("//*[@id='form-control input-group-inset input-group-inset-after']"));
		bird.sendKeys("03051978");

		// Why did you join the testing area?
		WebElement join = driver.findElement(By.xpath(
				"//*[@id='_com_liferay_dynamic_data_mapping_form_web_portlet_DDMFormPortlet_ddm$$WhyDidYouJoinTheTestingArea$762GAikF$0$$en_US']"));
		join.sendKeys("I like test.");

		// click
		WebElement submit = driver.findElement(By.xpath("//*[@id='submit']"));
		submit.click();

		// view a menssage
		if (driver.findElement(By.className("Information sent")) != null) {
			System.out.println("Passed");
		} else {
			System.out.println("Error");
		}
	}

}
