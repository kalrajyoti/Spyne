package com.qa.opencart.pages;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;
import com.qa.opencart.utils.JavaScriptUtil;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ImagePage {
    private WebDriver driver;
    private ElementUtil eleUtil;
    private JavaScriptUtil javaScriptUtil;
    Logger loggerFactory = LoggerFactory.getLogger(ImagePage.class);
    String imagePath;
    public static final String CHOOSE_BUTTON ="(//input[@type='file'])[2]";
    public static final By IMAGE = By.xpath("//img[@alt='input']");
    public static final String WAIT_FOR_UPLOADING = "//img[@src='https://spyne-static.s3.amazonaws.com/AI-tools/image_uploader_loader.gif']";
    public static final String WAIT_FOR_SPINNER = "//div[@class='spinner z-10']";
    public static final String ERROR_MESSAGE = "//div[contains(text(),'someting Went wrong')]";
    public static final String PROCESS = "//button[contains(.,'Process')][1]";
    public static final String UPLOAD_BUTTON="//p[@class=\"blue-btn m-auto w-52 h-[45px] cursor-pointer\"]";
    public static final String PROCESS_BUTTON=" //button[@class='px-10 blue-btn text-center hidden md:inline-flex items-center xl:text-sm lg:text-xs disabled:opacity-50 px-10 blue-btn text-center hidden md:inline-flex items-center xl:text-sm lg:text-xs disabled:opacity-50']";

    public ImagePage(WebDriver driver) {
        this.driver = driver;
        eleUtil = new ElementUtil(driver);
        javaScriptUtil =new JavaScriptUtil(driver);
    }
    @Step("Select the image path")
    public void selectPath(String imagePath){
        driver.findElement(By.xpath(CHOOSE_BUTTON)).sendKeys(imagePath);

    }
    @Step("click on upload image button")
    public void clickUploadImage(){
        javaScriptUtil.unhideChooseButton(CHOOSE_BUTTON);
    }
    @Step("Wait for uploading ")
    public void waitForUploading(){
        eleUtil.waitForElementToDisapper(By.xpath(WAIT_FOR_UPLOADING),50);
        eleUtil.waitForElementToDisapper(By.xpath(WAIT_FOR_SPINNER),50);
    }
    @Step("....getting login page title....")
    public boolean verifyImageIsUploaded() {
       WebElement imageLoaded=eleUtil.waitForElementPresence(IMAGE,10);
        return imageLoaded.isDisplayed();
    }
    @Step("....verify image is scaled ....")
    public boolean verifyImageIsScaled() {
        WebElement imageLoaded=eleUtil.waitForElementPresence(By.xpath(PROCESS),10);
        return imageLoaded.isEnabled();
    }

}
