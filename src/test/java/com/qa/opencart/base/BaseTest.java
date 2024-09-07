package com.qa.opencart.base;

import java.util.Properties;

import com.qa.opencart.pages.ImagePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.HomePage;

public class BaseTest {
	protected WebDriver driver;
	protected Properties prop;
	protected HomePage homePage;
	protected ImagePage imagePage;
	DriverFactory df;
	
	protected SoftAssert softAssert;
	
	@Parameters({"browser", "browserversion", "testname"})
	@BeforeTest
	public void setup(@Optional("chrome")String browserName, @Optional("128")String browserVersion,@Optional("BasePageTest") String testName) {
		df = new DriverFactory();
		prop = df.initProp();
		
			if(browserName!=null) {//it means passing the browser from testng.xml
				prop.setProperty("browser", browserName);
				prop.setProperty("browserversion", browserVersion);
				prop.setProperty("testname", testName);
			}
		
		
		driver = df.initDriver(prop);
		homePage = new HomePage(driver);
	//	imagePage = new ImagePage(homePage)
		softAssert = new SoftAssert();
	}
	
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	

}
