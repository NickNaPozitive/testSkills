package tests.auth;

import org.testng.annotations.Test;
import pages.auth.AuthorizationPage;
import tests.base.BaseTest;
import static constants.Constant.Urls.AUTH_PAGE;

public class AuthorizationTest extends BaseTest {

    @Test
    public void checkIsRedirectToAuth(){
        basePage.goToUrl(AUTH_PAGE);
        authorizationPage.clickToAuth();
        basePage.isAuthWindowPresented();
    }
}
