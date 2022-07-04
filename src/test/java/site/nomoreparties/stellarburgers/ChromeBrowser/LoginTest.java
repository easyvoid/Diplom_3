package site.nomoreparties.stellarburgers.ChromeBrowser;

import org.junit.Test;
import site.nomoreparties.stellarburgers.*;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;
import static org.junit.Assert.assertEquals;

public class LoginTest extends ChromeBaseTest {

    @Test
    public void loginButtonTest() {
        HomePage homePage = open(homePageURL, HomePage.class);
        LoginPage loginPage = homePage.waitAndPushLoginButton();

        webdriver().shouldHave(url(loginPageURL));
        loginPage.fullLogin(user.getEmail(), user.getPassword());

        webdriver().shouldHave(url(homePageURL));

        String actualEmail = homePage.checkAccountProfile();
        assertEquals(user.getEmail(),actualEmail);
    }

    @Test
    public void loginWithAccountButtonTest() {
        HomePage homePage = open(homePageURL, HomePage.class);
        homePage.waitAndPushAccountButton();

        webdriver().shouldHave(url(loginPageURL));
        LoginPage loginPage = page(LoginPage.class);

        loginPage.fullLogin(user.getEmail(), user.getPassword());

        webdriver().shouldHave(url(homePageURL));

        String actualEmail = homePage.checkAccountProfile();
        assertEquals(user.getEmail(),actualEmail);
    }

    @Test
    public void loginFromRegisterPageTest() {
        HomePage homePage = open(homePageURL, HomePage.class);
        LoginPage loginPage = homePage.waitAndPushLoginButton();
        webdriver().shouldHave(url(loginPageURL));
        RegisterPage registerPage = loginPage.waitAndPushRegisterLink();
        webdriver().shouldHave(url(registerPageURL));
        registerPage.waitAndPushLoginButton();
        webdriver().shouldHave(url(loginPageURL));

        loginPage.fullLogin(user.getEmail(), user.getPassword());

        webdriver().shouldHave(url(homePageURL));

        String actualEmail = homePage.checkAccountProfile();
        assertEquals(user.getEmail(),actualEmail);
    }

    @Test
    public void loginFromForgotPasswordPageTest() {
        HomePage homePage = open(homePageURL, HomePage.class);
        LoginPage loginPage = homePage.waitAndPushLoginButton();
        ForgotPasswordPage forgotPasswordPage = loginPage.waitAndPushForgotPasswordLink();
        forgotPasswordPage.waitAndPushLoginButton();

        loginPage.fullLogin(user.getEmail(), user.getPassword());

        webdriver().shouldHave(url(homePageURL));

        String actualEmail = homePage.checkAccountProfile();
        assertEquals(user.getEmail(),actualEmail);
    }
}