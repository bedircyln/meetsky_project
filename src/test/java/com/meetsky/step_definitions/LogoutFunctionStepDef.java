package com.meetsky.step_definitions;

import com.meetsky.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LogoutFunctionStepDef {

    @Given("User Logs in the account with valid credentials")
    public void user_logs_in_the_account_with_valid_credentials() {
        Driver.getDriver().get("https://qa.meetsky.net/index.php/login?redirect_url=/index.php/apps/files/?dir%3D/%26fileid%3D26047");

        String usernameValid = "Employee12";
        WebElement usernameInput = Driver.getDriver().findElement(By.id("user"));
        usernameInput.sendKeys(usernameValid);

        String passwordValid = "Employee123";
        WebElement passwordInput = Driver.getDriver().findElement(By.id("password"));
        passwordInput.sendKeys(passwordValid);

        Driver.getDriver().findElement(By.id("submit-form")).click();

    }
    @When("User on Files page")
    public void user_on_files_page() {
        System.out.println("--------------User on Files Page--------------");
    }
    @When("User clicks the icon on the upper right corner of the page")
    public void user_clicks_the_icon_on_the_upper_right_corner_of_the_page() {
        Driver.getDriver().findElement(By.xpath("//header/div[2]/div[4]/div[1]/div[1]")).click();
    }
    @When("User clicks the Log Out button on the opened menu under the clicked icon")
    public void user_clicks_the_log_out_button_on_the_opened_menu_under_the_clicked_icon() {
       Driver.getDriver().findElement(By.xpath("//header/div[2]/div[4]/nav[1]/ul[1]/li[4]")).click();
    }
    @Then("User should go to Log In page")
    public void user_should_go_to_log_in_page() {
       String loginPageTitle = Driver.getDriver().getTitle();

        Assert.assertEquals("Meetsky - QA",loginPageTitle);
    }



}
