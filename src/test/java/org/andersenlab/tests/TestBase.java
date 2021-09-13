package org.andersenlab.tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {
    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void setUp() {
        String chromeDriverPath = "\\src\\main\\resources\\chromedriver.exe";
        String path = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", path + chromeDriverPath);
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 15);
        driver.get("https://github.com/");
        driver.manage().window().setSize(new Dimension(1050, 840));
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
