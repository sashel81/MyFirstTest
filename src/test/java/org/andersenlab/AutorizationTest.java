package org.andersenlab;// Generated by Selenium IDE

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AutorizationTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setUp() {
        String chromeDriverPath = "\\src\\main\\resources\\chromedriver.exe";
        String path = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", path + chromeDriverPath);
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 15);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void autorization() {
        driver.get("https://github.com/");
        driver.manage().window().setSize(new Dimension(1050, 840));
        driver.findElement(By.linkText("Sign in")).click();
        driver.findElement(By.id("login_field")).sendKeys("viktorviktoria689@gmail.com");
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).sendKeys("Solomia2019!");
        driver.findElement(By.name("commit")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".octicon-plus")));

        List<WebElement> elements = driver.findElements(By.cssSelector(".octicon-plus"));
        assert (elements.size() == 1);
    }
}