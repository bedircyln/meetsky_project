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

    @Then("user should see the Please fill out this field message.")
    public void user_should_see_the_please_fill_out_this_field_message() {
        WebElement passwordBox = Driver.getDriver().findElement(By.id("password"));
        WebElement userBox = Driver.getDriver().findElement(By.id("user"));

        String valiMessage = passwordBox.getAttribute("validationMessage") ;
        Assert.assertEquals(valiMessage,"Please fill out this field");

    }
    @Then("user should see the Please fill out this field message on password input box")
    public void user_should_see_the_please_fill_out_this_field_message_on_password_input_box() {
        WebElement passwordBox = Driver.getDriver().findElement(By.id("password"));

        String valiMessage = passwordBox.getAttribute("validationMessage") ;
        Assert.assertEquals(valiMessage,"Please fill in this field.");
    }

    @Then("user should see the Please fill out this field message on username input box")
    public void user_should_see_the_please_fill_out_this_field_message_on_username_input_box() {
        WebElement userBox = Driver.getDriver().findElement(By.id("user"));

        String valiMessage = userBox.getAttribute("validationMessage") ;
        Assert.assertEquals(valiMessage,"Please fill in this field.");
    }

    @Then("user should see the password as form of dots")
    public void user_should_see_the_password_as_form_of_dots() {
        WebElement passwordBox = Driver.getDriver().findElement(By.id("password"));

        String isFormOfDots = passwordBox.getAttribute("type");
        Assert.assertEquals(isFormOfDots,"password");
    }


    @When("user cliks the eye image to see the password explicitly")
    public void user_cliks_the_eye_image_to_see_the_password_explicitly() {
        Driver.getDriver().findElement(By.xpath("//body/div[1]/div[1]/main[1]/div[1]/div[1]/form[1]/fieldset[1]/p[2]/a[1]/img[1]")).click();
    }

    @Then("user should see the password explicitly")
    public void user_should_see_the_password_explicitly() {
        WebElement passwordBox = Driver.getDriver().findElement(By.id("password"));

        String isFormOfDots = passwordBox.getAttribute("type");
        Assert.assertEquals(isFormOfDots,"text");
    }

    @When("user can see the Forgot password? link")
    public void user_can_see_the_forgot_password_link() {
       WebElement forgotlink = Driver.getDriver().findElement(By.id("lost-password"));
       Assert.assertTrue(forgotlink.isDisplayed());
    }
    @When("user clicks the Forgot password link")
    public void user_clicks_the_forgot_password_link() {
        Driver.getDriver().findElement(By.id("lost-password")).click();
    }

    @Then("user can see the Reset Password button")
    public void user_can_see_the_reset_password_button() {

        //BURASI SIKINTI
    }

    @Then("user can see the Username and Password placeholders as expected")
    public void user_can_see_the_username_and_password_placeholders_as_expected() {
        WebElement passwordBox = Driver.getDriver().findElement(By.id("password"));

        String passwordPlaceholder = passwordBox.getAttribute("placeholder");
        Assert.assertEquals(passwordPlaceholder,"Password");

        WebElement userBox = Driver.getDriver().findElement(By.id("user"));

        String usernamePlaceholder = userBox.getAttribute("placeholder") ;
        Assert.assertEquals(usernamePlaceholder,"Username or email");



    }



}
