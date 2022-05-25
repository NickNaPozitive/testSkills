import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;

import java.util.concurrent.TimeUnit;

public class FirstTest {
    String SITE_URL = "https://www.youtube.com/";
    public WebDriver driver;
    public WebElement searchBox;


    @BeforeTest
    public void start() throws Exception {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(false);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }


    @AfterTest
    public void closeSeleniumSession() {

        driver.close();
        driver.quit();

    }

    @Test
    public void testSearchGoogle() throws Exception{

        driver.get(SITE_URL);

        searchBox = driver.findElement(By.name("search_query"));
        searchBox.sendKeys("GUZNO");
        searchBox.submit();

        takeSceenshot();

    }

    private void takeSceenshot() throws Exception {

        TakesScreenshot ts = (TakesScreenshot)driver;
        File source = ts.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(source, new File("./screenshot.png"));

        System.out.println("The Screenshot is taken...");

    }

}
