package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

import static common.Config.BROWSER_AND_PLATFORM;
import static constants.Constant.TimeOutVariables.IMPLICIT_WAIT;


public class CommonActions extends Assert {

    public static WebDriver createDriver(){
        WebDriver driver = null;
        switch (BROWSER_AND_PLATFORM){
            case "CHROME_WIN":
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "MOZILLA":
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
                driver = new ChromeDriver();
                break;
            default:
                assertEquals(BROWSER_AND_PLATFORM, "qwe", "hello");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
        return driver;
    }
}
