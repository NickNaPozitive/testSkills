package pages.base;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static java.time.Duration.ofSeconds;

public class FirstTest {
    static String SITE_URL = "https://skills.etm.ru";
    Cookie authCookie = new Cookie("session-id", "018400253801541876801567042672");
    public WebDriver driver;
    public WebElement searchBox;


    @BeforeTest
    public void start() throws Exception {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(false);
        driver = new ChromeDriver(options);
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }


    @AfterTest
    public void closeSeleniumSession() {

        driver.quit();

    }

    @Test
    public void testSearchGoogle() throws Exception{

        driver.get(SITE_URL);

        driver.manage().addCookie(authCookie);
        driver.navigate().refresh();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        takeSceenshot();

    }

    private void takeSceenshot() throws Exception {

        TakesScreenshot ts = (TakesScreenshot)driver;
        File source = ts.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(source, new File("./screenshot.png"));

        System.out.println("The S creenshot is taken...");

    }

}
