package com.gm.careers.pages;

import com.gm.careers.utils.BrowserUtils;
import com.gm.careers.utils.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CareerSearchingPage extends BasePage {

    @FindBy(xpath = "//ppc-content[@key='gdpr-allowCookiesText']")
    private WebElement allowCookiePopUpBtn;

    @FindBy( xpath = "(//input[@type='search'])[1]")
    private WebElement searchBox;

    @FindBy( xpath = "(//span[.='Software Test Engineer'])[1]")
    private WebElement firstAppearedJob;


    public void clickAllowCookieBtn(){
        allowCookiePopUpBtn.click();
    }

    public void enterJobTitleAndNavigate() {
        BrowserUtils.enterTextThenENTER(searchBox, ConfigurationReader.getProperty("jobTitle"));

//        Actions enter = new Actions(Driver.getDriver());
//       enter.sendKeys(Keys.ENTER);

    }


    public void clickFirstPosition(){

        BrowserUtils.clickOnElement(firstAppearedJob);
    }


}
