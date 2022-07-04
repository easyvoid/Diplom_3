package site.nomoreparties.stellarburgers.YandexBrowser;

import org.junit.Test;
import site.nomoreparties.stellarburgers.*;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;


public class ExitButtonTest extends YandexBaseTest {

    @Test
    public void exitButtonTest() {
        HomePage homePage = open(homePageURL, HomePage.class);
        LoginPage loginPage = page(LoginPage.class);
        homePage.waitAndPushLoginButton();
        loginPage.loginUser(user.getEmail(), user.getPassword());
        AccountProfilePage accountProfilePage = homePage.waitAndPushAccountButton();
        homePage.loginButtonShouldDisappear();
        accountProfilePage.waitAndPushExitButton();
        webdriver().shouldHave(url(loginPageURL));
    }
}
