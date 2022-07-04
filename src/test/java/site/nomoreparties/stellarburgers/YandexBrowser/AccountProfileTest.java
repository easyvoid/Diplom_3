package site.nomoreparties.stellarburgers.YandexBrowser;

import org.junit.Test;
import site.nomoreparties.stellarburgers.*;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;



public class AccountProfileTest extends YandexBaseTest {

    @Test
    public void pushAccountButtonNotAuthTest() {
        HomePage homePage = open(homePageURL, HomePage.class);
        homePage.waitAndPushAccountButton();

        webdriver().shouldHave(url(loginPageURL));
    }

    @Test
    public void pushAccountButtonAuthTest() {
        HomePage homePage = open(homePageURL, HomePage.class);
        LoginPage loginPage = page(LoginPage.class);
        homePage.waitAndPushLoginButton();
        loginPage.loginUser(user.getEmail(), user.getPassword());

        webdriver().shouldHave(url(homePageURL));

        homePage.waitAndPushAccountButton();
        webdriver().shouldHave(url(profilePageURL));
    }
}