package tests.events;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static constants.Constant.Urls.FUTURE_EVENTS_PAGE;

public class FutureEventsTest extends BaseTest {

    @Test
    public void selectNearByEvents() {
        basePage.goToUrl(FUTURE_EVENTS_PAGE);
        futureEventsPage.regOnEvent();
        basePage.isAuthWindowPresented();
    }
}
