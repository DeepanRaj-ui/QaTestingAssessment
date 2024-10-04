package org.example.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(name = "username")
    WebElement username;

    @FindBy(name = "password")
    WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginButton;

    @FindBy(xpath = "//span[text()='Admin']")
    WebElement clickAdmin;

    @FindBy(xpath = "//i[@class='oxd-icon bi-plus oxd-button-icon']")
    WebElement clickAddButton;

    @FindBy(xpath = "(//div[text()='-- Select --'])[1]")
    WebElement userroleDropdown;

    @FindBy(xpath = "//div[@class='oxd-select-option']//span[text()='Admin']")
    WebElement adminDropdown;

    @FindBy(xpath = "//div[@class='oxd-select-option']//span[text()='Enabled']")
    WebElement enabledDropdown;

    @FindBy(xpath = "//div[@class='oxd-topbar-header-title']//*[text()='Dashboard']")
    WebElement DashboardName;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement saveButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(String user) {
        wait.until(ExpectedConditions.visibilityOf(username));
        username.sendKeys(user);
    }

    public void enterPassword(String pass) {
        wait.until(ExpectedConditions.visibilityOf(password));
        password.sendKeys(pass);
    }

    public void clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
    }

    public boolean verifyDashboard(){
        wait.until(ExpectedConditions.visibilityOf(DashboardName));
        return DashboardName.isDisplayed();
    }

    public void clickAdmin(){
        wait.until(ExpectedConditions.visibilityOf(clickAdmin));
        clickAdmin.click();
    }

    public void clickAddButton(){
        wait.until(ExpectedConditions.visibilityOf(clickAddButton));
        clickAddButton.click();
    }

    public void clickUserRole(){
        wait.until(ExpectedConditions.visibilityOf(userroleDropdown));
        userroleDropdown.click();
    }

    public void clickAdminRole(){
        wait.until(ExpectedConditions.visibilityOf(adminDropdown));
        adminDropdown.click();
    }

    public void clickStatusRole(){
        wait.until(ExpectedConditions.visibilityOf(userroleDropdown));
        userroleDropdown.click();
    }

    public void clickEnabled(){
        wait.until(ExpectedConditions.visibilityOf(enabledDropdown));
        enabledDropdown.click();
    }

    public void clickSave(){
        wait.until(ExpectedConditions.visibilityOf(saveButton));
        saveButton.click();
    }

    public void entervaluesinSection(String lable,String text){
        WebElement element = driver.findElement(By.xpath("//label[contains(text(),'"+lable+"')]//..//..//input"));
        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(text);
    }




}
