package com.gm.careers.stepDefinitions;

import com.gm.careers.pages.ApplyingPage;
import com.gm.careers.pages.CareerSearchingPage;
import com.gm.careers.pages.HomePage;
import com.gm.careers.utils.BrowserUtils;
import com.gm.careers.utils.ConfigurationReader;
import com.gm.careers.utils.Driver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import java.util.concurrent.TimeUnit;

public class SearchAndApplyCareerStepDefinitions {

    HomePage homePage = new HomePage();
    CareerSearchingPage careerSearchingPage = new CareerSearchingPage();
    ApplyingPage applyingPage = new ApplyingPage();



    @Given("user on the GM homepage")
    public void user_on_the_gm_homepage() {
        System.out.println("::: Starting Automation:::");
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @And("user clicks Careers Tab")
    public void user_clicks_careers_tab() throws InterruptedException {
        homePage.clickOnCareersTab();
        Thread.sleep(2000);
    }


    @When("user input job title or id")
    public void user_input_job_title_or_id() throws InterruptedException {
        careerSearchingPage.clickAllowCookieBtn();
        careerSearchingPage.enterJobTitleAndNavigate();
        Thread.sleep(3000);

    }

    @And("select the first position")
    public void select_the_first_position() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor)Driver.getDriver();
        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(2000);
        careerSearchingPage.clickFirstPosition();
        Thread.sleep(3000);
    }


    @And("click apply now button")
    public void click_apply_now_button() {

        applyingPage.clickApplyNowBtn();
    }

    @And("user sign in to apply")
    public void user_sign_in_to_apply() throws InterruptedException {
        applyingPage.enterCredentials();
        Thread.sleep(2000);
        applyingPage.clickSignInBtn();
        Thread.sleep(2000);

    }


    @Then("verify user applied successfully")
    public void verify_user_applied_successfully() throws InterruptedException {
        String expectedMessage = "You've already applied for this job.";
        String actualMessage = applyingPage.getPageMessageText().trim();

        Assert.assertEquals("Test Failed!!!",expectedMessage,actualMessage);
        System.out.println("I've already applied for this job!~~");
        Thread.sleep(2000);

        Driver.closeDriver();

    }



}
