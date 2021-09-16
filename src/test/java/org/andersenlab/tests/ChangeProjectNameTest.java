package org.andersenlab.tests;

import io.qameta.allure.junit4.DisplayName;
import org.andersenlab.helpers.CreatedProjectPage;
import org.andersenlab.helpers.HomePage;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import static org.junit.Assert.assertEquals;

public class ChangeProjectNameTest extends TestBase {
    private WebDriver driver;
    private WebDriverWait wait;
    private HomePage homePage;
    private Properties properties;
    private CreatedProjectPage createdProjectPage;


    @Before
    public void autorizationAndProjectCreation() throws IOException {
        driver = super.driver;
        properties = new Properties();
        properties.load(new FileReader(new File("src/main/resources/local.properties")));
        homePage = new HomePage(driver);
        CharSequence uniqueName = "aData_" + System.currentTimeMillis();
        createdProjectPage = homePage.clickSignIn()
                .setUsername(properties.getProperty("web.username"))
                .setPassword(properties.getProperty("web.password"))
                .clickCommitButton()
                .selectNewProject()
                .createProject(uniqueName);
    }

    @Test
    @DisplayName("Change project name test")
    public void projectRename() throws InterruptedException {
        CharSequence uniqueNameNew = "aData_" + System.currentTimeMillis();
        String Actual = createdProjectPage.changeNameOfProject(uniqueNameNew)
                .getActualTitle();
        Thread.sleep(2000);
        assertEquals(uniqueNameNew, Actual);
    }


}
