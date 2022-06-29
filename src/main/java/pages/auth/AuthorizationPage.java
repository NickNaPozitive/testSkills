package pages.auth;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

public class AuthorizationPage extends BasePage {

    public AuthorizationPage(WebDriver driver) {
        super(driver);
    }
    private final By buttonAuth = By.xpath("//*[@id=\"__next\"]/div/header/div/div[3]/div[1]/button");

    public AuthorizationPage clickToAuth(){
        driver.findElement(buttonAuth).click();
        return this;
    }
}
