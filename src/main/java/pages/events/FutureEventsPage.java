package pages.events;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FutureEventsPage {
    WebDriver driver;
    public FutureEventsPage(WebDriver driver){
        this.driver = driver;
    }

    public final By tabNearByEvents = By.xpath("//*[@id=\"__next\"]/div/header/div/div[3]/div[2]/button");

    public void regOnEvent(){
        driver.findElement(tabNearByEvents).click();
    }


}
