package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

import io.qameta.allure.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomePage {
Logger loggerFactory =LoggerFactory.getLogger(HomePage.class);
	private WebDriver driver;
	private ElementUtil eleUtil;
	// 2. public Page Constructor
	public HomePage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	// 3. public Page actions/methods
	
	@Step("....getting Home page title....")
	public String getHomePageTitle() {
		String title = eleUtil.waitForTitleIs(AppConstants.HOME_PAGE_TITLE, AppConstants.SHORT_TIME_OUT);
		loggerFactory.info("Home Page title is: " + title);
		return title;
	}

	@Step("....verify Home page url....")
	public String getHomePageURL() {
		String url = eleUtil.waitForURLContains(AppConstants.HOME_PAGE_URL_FRACTION, AppConstants.SHORT_TIME_OUT);
		loggerFactory.info("HOME Page url is: " + url);
		return url;
	}
	
	@Step("navigating to register page....")
	public ImagePage navigateToImagePage() {
		driver.navigate().to("https://www.spyne.ai/image-upscaler/upload");
		return new ImagePage(driver);
	}
	
	
	

}
