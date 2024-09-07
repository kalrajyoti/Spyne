package com.qa.opencart.tests;

import com.qa.opencart.base.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Epic("EPIC - 101: Verify the File Upload of SPYNE ")
@Story("US - 201: implement file upload page features for SPYNE")
public class ImagePageTest extends BaseTest {
    String imagePath;
    @BeforeClass
    public void regSetup() {
      imagePage = homePage.navigateToImagePage();
    }
    @Test(description = "Test Valid upload image ",priority = 3)
    @Feature("File upload functionality")
    @Severity(SeverityLevel.CRITICAL)
    public void testValidFileUpload(){
        imagePath =System.getProperty("user.dir") + "/src/test/resources/fileformats/test.jpeg";
        imagePage.clickUploadImage();
        imagePage.selectPath(imagePath);
        imagePage.waitForUploading();
        imagePage.verifyImageIsUploaded();
    }
    @Test(description = "Test image upscaling upload image ",priority = 4,dependsOnMethods = "testValidFileUpload")
    @Feature("File upload functionality")
    @Severity(SeverityLevel.CRITICAL)
    public void testImageUpScaling(){
        imagePage.verifyImageIsScaled();
    }
}
