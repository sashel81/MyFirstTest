package org.andersenlab.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;
    public By signInButton = By.linkText("Sign in");
    public By octicon = By.cssSelector(".octicon-plus");
    public By headerMenuTab = By.cssSelector(".Header-item:nth-child(6) .Header-link");
    public By newProjectTab = By.linkText("New project");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage clickSignIn() {
        driver.findElement(signInButton).click();
        return new LoginPage(driver);
    }
    public int isHomePageAppear() {
        wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.presenceOfElementLocated(octicon));
        List<WebElement> elements = driver.findElements(octicon);
        return elements.size();
    }
    public ProjectPage selectNewProject() {
        driver.findElement(headerMenuTab).click();
        driver.findElement(newProjectTab).click();
        return new ProjectPage(driver);
    }
}
