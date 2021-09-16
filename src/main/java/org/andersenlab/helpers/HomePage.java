package org.andersenlab.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;
    @FindBy(linkText = "Sign in")
    private WebElement signInButton ;
    @FindBy(css = ".octicon-plus")
    private WebElement octicon;
    @FindBy(css = ".octicon-plus")
    private List<WebElement> octicons;
    @FindBy(css = ".Header-item:nth-child(6) .Header-link")
    private WebElement headerMenuTab;
    @FindBy(linkText = "New project")
    private WebElement newProjectTab;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public LoginPage clickSignIn() {
        signInButton.click();
        return new LoginPage(driver);
    }
    public int isHomePageAppear() {
        wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOf(octicon));
        List<WebElement> elements = octicons;
        return elements.size();
    }
    public ProjectPage selectNewProject() {
        headerMenuTab.click();
        newProjectTab.click();
        return new ProjectPage(driver);
    }
}
