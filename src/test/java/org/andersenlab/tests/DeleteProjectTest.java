package org.andersenlab.tests;

import org.andersenlab.helpers.CreatedProjectPage;
import org.andersenlab.helpers.HomePage;
import org.andersenlab.helpers.LoginPage;
import org.andersenlab.helpers.ProjectPage;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class DeleteProjectTest extends TestBase {
    private WebDriver driver;
    private WebDriverWait wait;
    private HomePage homePage;
    private LoginPage loginPage;
    private Properties properties;
    private HomePage homePageNew;
    private ProjectPage projectPage;
    private CreatedProjectPage createdProjectPage;
    private CharSequence uniqueName;

    @Before
    public void autorizationAndProjectCreation() throws IOException {
        driver = super.driver;
        properties = new Properties();
        properties.load(new FileReader(new File("src/main/resources/local.properties")));
        HomePage homePage = new HomePage(driver);
        loginPage = homePage.clickSignIn();
        loginPage.setUsername(properties.getProperty("web.username"));
        loginPage.setPassword(properties.getProperty("web.password"));
        homePageNew = loginPage.clickCommitButton();
        projectPage = homePage.selectNewProject();
        uniqueName = "aData_" + System.currentTimeMillis();
        createdProjectPage = projectPage.createProject(uniqueName);
    }

    @Test
    public void DeleteProjectTest() {
        createdProjectPage.deleteProject(uniqueName);
        assert (createdProjectPage.findDeletedProjectName(uniqueName) == 0);
    }
}
