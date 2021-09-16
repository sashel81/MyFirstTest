package org.andersenlab.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProjectPage {
    WebDriver driver;
    WebDriverWait wait;
    @FindBy (id="project_name")
    private WebElement projectField;

   @FindBy(id ="project_body")
    private  WebElement projectBodyField;

    @FindBy(id ="project_public_true")
    private WebElement projectType;

    @FindBy(css=".btn-primary")
    private WebElement createProjectButton;

    public ProjectPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public CreatedProjectPage createProject(CharSequence uniqueName) {
        projectField.click();
        projectField.sendKeys(uniqueName);
        projectBodyField.click();
       projectBodyField.sendKeys("test");
        projectType.click();
        createProjectButton.click();
        return new CreatedProjectPage(driver);
    }
}
