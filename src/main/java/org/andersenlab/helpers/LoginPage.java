package org.andersenlab.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    @FindBy (id = "login_field")
    private WebElement loginField;

    @FindBy (id = "password")
    private WebElement passwordField;

    @FindBy (name = "commit")
    private WebElement commitButton;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public LoginPage setUsername(String username) {
        loginField.sendKeys(username);
        return this;
    }

    public LoginPage setPassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    public HomePage clickCommitButton() {
        commitButton.click();
        return new HomePage(driver);
    }
}
