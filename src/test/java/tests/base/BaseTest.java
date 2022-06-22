package tests.base;

import common.CommonActions;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.annotations.TestInstance;
import pages.auth.AuthorizationPage;
import pages.base.BasePage;

import static common.Config.CLEAR_COOKIES;
import static common.Config.HOLD_BROWSER_OPEN;

//@TestInstance(LifeCycle.PER_CLASS)
public class BaseTest {

    protected WebDriver driver = CommonActions.createDriver();
    protected BasePage basePage = new BasePage(driver);
    protected AuthorizationPage authorizationPage = new AuthorizationPage(driver);

    @AfterMethod
    public void clearCookiesAndLocalStorage(){
        if(CLEAR_COOKIES){
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            driver.manage().deleteAllCookies();
            javascriptExecutor.executeScript("window.sessionStorage.clear()");
        }
    }
    @AfterTest
    public void close(){
        if(!HOLD_BROWSER_OPEN){
            driver.quit();
        }
    }
}
