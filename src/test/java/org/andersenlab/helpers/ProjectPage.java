package org.andersenlab.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProjectPage {
    WebDriver driver;
    WebDriverWait wait;
    public By projectField = By.id("project_name");
    public By projectBodyField = By.id("project_body");
    public By projectType = By.id("project_public_true");
    public By createProjectButton = By.cssSelector(".btn-primary");

    public ProjectPage(WebDriver driver) {
        this.driver = driver;
    }

    public CreatedProjectPage createProject(CharSequence uniqueName) {
        driver.findElement(projectField).click();
        driver.findElement(projectField).sendKeys(uniqueName);
        driver.findElement(projectBodyField).click();
        driver.findElement(projectBodyField).sendKeys("test");
        driver.findElement(projectType).click();
        driver.findElement(createProjectButton).click();
        return new CreatedProjectPage(driver);
    }
}
