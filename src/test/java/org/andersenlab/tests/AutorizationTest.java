package org.andersenlab.tests;// Generated by Selenium IDE

import org.andersenlab.helpers.HomePage;
import org.andersenlab.helpers.LoginPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class AutorizationTest extends TestBase {
    private WebDriver driver;
    private WebDriverWait wait;
    private HomePage homePage;
    private LoginPage loginPage;
    private Properties properties;
    private HomePage homePageNew;

    @Test
    public void autorization() throws IOException {
        driver = super.driver;
        properties = new Properties();
        properties.load(new FileReader(new File("src/main/resources/local.properties")));
        HomePage homePage = new HomePage(driver);
        loginPage = homePage.clickSignIn();

        loginPage.setUsername(properties.getProperty("web.username"));
        loginPage.setPassword(properties.getProperty("web.password"));
        homePageNew=loginPage.clickCommitButton();
        assert (homePageNew.isHomePageAppear() == 1);
    }
}