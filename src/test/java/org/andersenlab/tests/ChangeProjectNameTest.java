package org.andersenlab.tests;

import org.andersenlab.helpers.CreatedProjectPage;
import org.andersenlab.helpers.HomePage;
import org.andersenlab.helpers.LoginPage;
import org.andersenlab.helpers.ProjectPage;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ChangeProjectNameTest extends TestBase {
    private WebDriver driver;
    private WebDriverWait wait;
    private HomePage homePage;
    private LoginPage loginPage;
    private Properties properties;
    private HomePage homePageNew;
    private ProjectPage projectPage;
    private CreatedProjectPage createdProjectPage;


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
        CharSequence uniqueName = "aData_" + System.currentTimeMillis();
        createdProjectPage = projectPage.createProject(uniqueName);
    }

    @Test
    public void projectRename() throws InterruptedException {
        CharSequence uniqueNameNew = "aData_" + System.currentTimeMillis();
        createdProjectPage.changeNameOfProject(uniqueNameNew);
        String Actual = createdProjectPage.getActualTitle();
        Thread.sleep(2000);
        assertEquals(uniqueNameNew, Actual);
    }


}
