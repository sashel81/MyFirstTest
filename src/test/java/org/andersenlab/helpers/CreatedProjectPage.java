package org.andersenlab.helpers;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CreatedProjectPage {
    WebDriver driver;
    WebDriverWait wait;
    @FindBy(css = ".js-project-name-label")
    private WebElement projectNameTittle;

    @FindBy(className = "project-name-edit-action")
    private WebElement projectNameEditBut;

    @FindBy(css = ".js-quick-submit")
    private WebElement projectNameEditField;

    @FindBy(css = ".js-project-name-update button[type=Submit][class*=mr-2]")
    private WebElement saveNameButton;


    @FindBy(xpath = "//*[contains(@class, 'pagehead-tabs-item') and contains(., 'Projects')]")
    private WebElement projectsTab;

    @FindBy (css="details[open] [role='menuitem']")
    private List<WebElement> editProjectTab;

    private String projectNameTabTemplate = "//a[contains(text(),'%s')]/ancestor::div[contains(@class, 'Box-row')]//summary";


    @FindBy (css = ".btn-danger[type='submit']")
    private WebElement deleteProjectButton;

    public CreatedProjectPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public String getActualTitle() {
        wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOf(projectNameTittle));
        String actualTitle = projectNameTittle.getText();
        return actualTitle;
    }

    public CreatedProjectPage changeNameOfProject(CharSequence uniqueName) {
        wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOf(projectNameTittle));
        projectNameEditBut.click();
        projectNameEditField.clear();
        projectNameEditField.sendKeys(uniqueName);
        saveNameButton.click();
        wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.invisibilityOf(saveNameButton));
        return this;
    }

    public CreatedProjectPage deleteProject(CharSequence uniqueName) {
        wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOf(projectsTab));
        projectsTab.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(String.format(projectNameTabTemplate, uniqueName))));
        driver.findElement(By.xpath(String.format(projectNameTabTemplate, uniqueName))).click();
        wait = new WebDriverWait(driver, 15);
        List<WebElement> dropdownElements = editProjectTab;
        dropdownElements.get(0).click();
        wait.until(ExpectedConditions.visibilityOf(deleteProjectButton));
        deleteProjectButton.click();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        wait = new WebDriverWait(driver, 15);
        alert.accept();
        return this;
    }

    public int findDeletedProjectName(CharSequence uniqueName) {
        List<WebElement> deletedProjectName = driver.findElements(By.xpath(String.format(projectNameTabTemplate, uniqueName)));
        return deletedProjectName.size();
    }
}
