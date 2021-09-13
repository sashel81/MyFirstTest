package org.andersenlab.helpers;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CreatedProjectPage {
    WebDriver driver;
    WebDriverWait wait;
    public By projectNameTittle = By.cssSelector(".js-project-name-label");
    public By projectNameEditBut = By.className("project-name-edit-action");
    public By projectNameEditField = By.cssSelector(".js-quick-submit");
    public By saveNameButton = By.cssSelector(".js-project-name-update button[type=Submit][class*=mr-2]");
    public By projectsTab = By.xpath("//*[contains(@class, 'pagehead-tabs-item') and contains(., 'Projects')]");
    public String projectNameTabTemplate = "//a[contains(text(),'%s')]/ancestor::div[contains(@class, 'Box-row')]//summary";
    public By editProjectTab = By.cssSelector("details[open] [role='menuitem']");
    public By deleteProjectButton = By.cssSelector(".btn-danger[type='submit']");

    public CreatedProjectPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getActualTitle() {
        wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.presenceOfElementLocated(projectNameTittle));
        String actualTitle = driver.findElement(projectNameTittle).getText();
        return actualTitle;
    }

    public void changeNameOfProject(CharSequence uniqueName) {
        wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.presenceOfElementLocated(projectNameTittle));
        driver.findElement(projectNameTittle);
        driver.findElement(projectNameEditBut).click();
        driver.findElement(projectNameEditField).clear();
        driver.findElement(projectNameEditField).sendKeys(uniqueName);
        driver.findElement(saveNameButton).click();
        wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(saveNameButton));
    }

    public void deleteProject(CharSequence uniqueName) {
        wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.presenceOfElementLocated(projectsTab));
        driver.findElement(projectsTab).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(String.format(projectNameTabTemplate,uniqueName))));
        driver.findElement(By.xpath(String.format(projectNameTabTemplate,uniqueName))).click();
        wait = new WebDriverWait(driver, 15);
        List<WebElement> dropdownElements = driver.findElements(editProjectTab);
        dropdownElements.get(0).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(deleteProjectButton));
        driver.findElement(deleteProjectButton).click();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        wait = new WebDriverWait(driver, 15);
        alert.accept();
    }

    public int findDeletedProjectName(CharSequence uniqueName) {
        List<WebElement> deletedProjectName = driver.findElements(By.xpath(String.format(projectNameTabTemplate,uniqueName)));
        return deletedProjectName.size();
    }
}
