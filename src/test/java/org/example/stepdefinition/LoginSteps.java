package org.example.stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.pageObjects.LoginPage;
import org.example.utilities.ExcelReader;
import org.example.utilities.configReader;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;
import java.util.Random;

public class LoginSteps {
    WebDriver driver = Hooks.driver;
    org.example.utilities.configReader configReader = new configReader();
    LoginPage loginPage = new LoginPage(driver);

    @Given("I navigate to login Page and logged in using valid credentials")
    public void i_navigate_to_login_page_and_logged_in_using_valid_credentials() throws IOException {
        driver.get(configReader.getBaseURL());
        List<String[]> data = ExcelReader.readExcelData( "LoginCredentials");
        String username = data.get(1)[0];
        String password = data.get(1)[1];
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
    }

    @Then("User verifies logged in successfully")
    public void user_verifies_logged_in_successfully() {
        Assert.assertTrue(loginPage.verifyDashboard(),"Dashboard is not avilable");
    }

    @Then("User click admin from side bar")
    public void user_click_admin_from_side_bar() {
        loginPage.clickAdmin();
    }

    @Then("User click add button")
    public void user_click_add_button() {
        loginPage.clickAddButton();
    }

    @Then("User click user role from the drop down")
    public void user_click_user_role_from_the_drop_down() {
        Random random = new Random();
        String username = "User" + random.nextInt(1000);
        loginPage.clickUserRole();
        loginPage.clickAdminRole();
        loginPage.clickStatusRole();
        loginPage.clickEnabled();
        loginPage.entervaluesinSection("Employee Name","1234  kumar");
        loginPage.entervaluesinSection("Username",username);
        loginPage.entervaluesinSection("Password","1234567a");
        loginPage.entervaluesinSection("Confirm Password","1234567a");
        loginPage.clickSave();

    }


}
