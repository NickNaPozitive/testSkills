package pages.base;

import org.openqa.selenium.By;
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

    private final By cityChange = By.xpath("//*[@id=\"__next\"]/div/header/div/div[3]/div[1]/div/div/div");

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

    public void isAuthWindowPresented(){
        WebElement listOfCities = driver.findElement(cityChange);
        waitElementIsVisible(listOfCities);
    }
}
