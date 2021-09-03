package org.andersenlab;

//import static org.junit.Assert.assertTrue;

//import org.junit.Test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Driver;

//import org.openqa.selenium.firefox.FirefoxDriver;
public class MyFirstTestClass {
    String email = "viktorviktoria689@gmail.com";

    @Test
    public void testEmailField() {
        String chromeDriverPath = "\\src\\main\\resources\\chromedriver.exe";
        String path = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", path + chromeDriverPath);
        WebDriver driver = new ChromeDriver();
        driver.get("https://github.com/");
        driver.findElement(By.linkText("Sign in")).click();

        driver.findElement(By.id("login_field")).sendKeys(email);
        String actualEmail = driver.findElement(By.id("login_field")).getAttribute("value");
        Assert.assertEquals(email,actualEmail);
        driver.quit();
    }

}



