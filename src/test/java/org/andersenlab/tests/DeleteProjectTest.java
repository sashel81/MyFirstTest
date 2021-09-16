package org.andersenlab.tests;

import io.qameta.allure.junit4.DisplayName;
import org.andersenlab.helpers.CreatedProjectPage;
import org.andersenlab.helpers.HomePage;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class DeleteProjectTest extends TestBase {
    private WebDriver driver;
    private HomePage homePage;
     private Properties properties;
     private CreatedProjectPage createdProjectPage;
    private CharSequence uniqueName;

    @Before
    public void autorizationAndProjectCreation() throws IOException {
        driver = super.driver;
        properties = new Properties();
        properties.load(new FileReader(new File("src/main/resources/local.properties")));
        homePage = new HomePage(driver);
        uniqueName = "aData_" + System.currentTimeMillis();
        createdProjectPage = homePage.clickSignIn()
                .setUsername(properties.getProperty("web.username"))
                .setPassword(properties.getProperty("web.password"))
                .clickCommitButton()
                .selectNewProject()
                .createProject(uniqueName);
    }

    @Test
    @DisplayName("Delete project test")
    public void DeleteProjectTest() {
                createdProjectPage.deleteProject(uniqueName);
        assert (createdProjectPage.findDeletedProjectName(uniqueName) == 0);
    }
}
