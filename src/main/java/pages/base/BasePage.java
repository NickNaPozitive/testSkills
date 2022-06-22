package pages.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.auth.AuthorizationPage;

import static constants.Constant.TimeOutVariables.EXPLICIT_WAIT;

public class BasePage {

    public WebDriver driver;
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    /*
    * Метод для открытия определеннго URL
    * */
    public void goToUrl(String url){
        driver.get(url);
    }

    /*
    * Ожидание видимости элемента в DOM модели
    * */
    public WebElement waitElementIsVisible(WebElement element){
        new WebDriverWait(driver, EXPLICIT_WAIT).until(ExpectedConditions.visibilityOf(element));
        return element;
    }
}
