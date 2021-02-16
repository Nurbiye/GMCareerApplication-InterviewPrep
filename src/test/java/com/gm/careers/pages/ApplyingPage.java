package com.gm.careers.pages;

import com.gm.careers.utils.BrowserUtils;
import com.gm.careers.utils.ConfigurationReader;
import com.gm.careers.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ApplyingPage extends BasePage{

    @FindBy( xpath = "//ppc-content[@data-ph-id='ph-page-element-page34-g4cQDr']")
    private WebElement applyNowButton;

    public void clickApplyNowBtn(){
        BrowserUtils.clickOnElement(applyNowButton);
    }


    @FindBy(xpath = "//input[@id='input-3']")
    private WebElement userNameInputBox;

    @FindBy(xpath = "//input[@id='input-4']")
    private WebElement passwordInputBox;

    @FindBy(xpath = "//div[@class='css-bkuh8c']")
    private WebElement signInButton;

    public void enterCredentials(){
// Switch to new window opened
        for(String winHandle : Driver.getDriver().getWindowHandles()){
            Driver.getDriver().switchTo().window(winHandle);
        }
        BrowserUtils.enterText(userNameInputBox, ConfigurationReader.getProperty("my.username"));
        BrowserUtils.enterText(passwordInputBox, ConfigurationReader.getProperty("my.password"));

    }
    public void clickSignInBtn(){

        BrowserUtils.clickOnElement(signInButton);
    }


    @FindBy(xpath = "//span[@id='wd-FieldSet-NO_METADATA_ID-uid13-label']")
    private WebElement pageMessage;

    public String getPageMessageText(){
        return pageMessage.getText();
    }

}
