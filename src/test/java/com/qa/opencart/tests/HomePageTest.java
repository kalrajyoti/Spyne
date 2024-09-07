package com.qa.opencart.tests;

import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

//@Listeners(ExtentReportListener.class)



@Epic("EPIC - 100: Verify the Home Page of SPYNE ")
@Story("US - 200: implement Home page features for SPYNE")
public class HomePageTest extends BaseTest {
	String imagePath;
	@Description("Home page title test......")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 1)
	public void loginPageTitleTest() {
		String actTitle = homePage.getHomePageTitle();
		Assert.assertEquals(actTitle, AppConstants.HOME_PAGE_TITLE);

	}

	@Description("home page url test......")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 2)
	public void loginPageURLTest() {
		String actURL = homePage.getHomePageURL();
		Assert.assertTrue(actURL.contains(AppConstants.HOME_PAGE_URL_FRACTION));

	}
}
