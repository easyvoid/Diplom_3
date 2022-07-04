package site.nomoreparties.stellarburgers.ChromeBrowser;

import org.junit.Test;
import site.nomoreparties.stellarburgers.ChromeBaseTest;
import site.nomoreparties.stellarburgers.HomePage;
import site.nomoreparties.stellarburgers.LoginPage;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;


public class AccountProfileTest extends ChromeBaseTest {

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