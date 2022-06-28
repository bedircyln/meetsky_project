package com.meetsky.step_definitions;

import com.meetsky.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MeetskyStepDefinitions {

    @Given("user goes to log in page")
    public void user_goes_to_log_in_page() {
        Driver.getDriver().get("https://qa.meetsky.net/index.php/login?redirect_url=/index.php/apps/files/?dir%3D/%26fileid%3D26047");
    }
    @When("user on Meetsky LogIn page")
    public void user_on_meetsky_log_in_page() {
        System.out.println("-----------User on LogIn page.------------");
    }
    @When("user enters valid username")
    public void user_enters_valid_username() {
        String usernameValid = "Employee12";
        WebElement usernameInput = Driver.getDriver().findElement(By.id("user"));
        usernameInput.sendKeys(usernameValid);
    }
    @When("user enters valid password")
    public void user_enters_valid_password() {
        String passwordValid = "Employee123";
        WebElement passwordInput = Driver.getDriver().findElement(By.id("password"));
        passwordInput.sendKeys(passwordValid);
    }
    @When("user clicks Log In button")
    public void user_clicks_log_in_button() {
        Driver.getDriver().findElement(By.id("submit-form")).click();
    }
    @Then("user should see the Files-Meetsky-QA title on the opened Files page")
    public void user_should_see_the_files_meetsky_qa_title_on_the_opened_files_page() {
        String expectedTitle = "Files - Meetsky - QA";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
    }

    @When("user enters invalid username")
    public void user_enters_invalid_username() {
        String usernameInvalid = "Invalid_Username";
        WebElement usernameInput = Driver.getDriver().findElement(By.id("user"));
        usernameInput.sendKeys(usernameInvalid);
    }
    @Then("user should see the Wrong username or password warning")
    public void user_should_see_the_wrong_username_or_password_warning() {
        WebElement invalidUsernameOrPasswordMessage = Driver.getDriver().findElement(By.xpath("//p[contains(text(),'Wrong username or password.')]"));
        Assert.assertTrue(invalidUsernameOrPasswordMessage.isDisplayed());
    }


    @When("user enters invalid password")
    public void user_enters_invalid_password() {
        String passwordInvalid = "Invalid_Password";
        WebElement passwordInput = Driver.getDriver().findElement(By.id("password"));
        passwordInput.sendKeys(passwordInvalid);
    }




}
