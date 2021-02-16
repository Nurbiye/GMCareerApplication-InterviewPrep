package com.gm.careers.pages;

import com.gm.careers.utils.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    @FindBy(xpath = "(//a[@class='menu__link stat-text-link'])[2]")
    private WebElement careers ;

    public void clickOnCareersTab(){
        BrowserUtils.clickOnElement(careers);
    }

}