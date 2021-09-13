package org.andersenlab.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;
    public By loginField = By.id("login_field");
    public By passwordField = By.id("password");
    public By commitButton = By.name("commit");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setUsername(String username) {
        driver.findElement(loginField).sendKeys(username);
    }

    public void setPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public HomePage clickCommitButton() {
        driver.findElement(commitButton).click();
        return new HomePage(driver);
    }
}
