package com.gm.careers.pages;

import com.gm.careers.utils.Driver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public BasePage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

}
