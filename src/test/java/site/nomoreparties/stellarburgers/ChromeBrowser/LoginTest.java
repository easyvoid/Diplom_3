package site.nomoreparties.stellarburgers.ChromeBrowser;

import api.User;
import api.UserClient;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.ForgotPasswordPage;
import site.nomoreparties.stellarburgers.HomePage;
import site.nomoreparties.stellarburgers.LoginPage;
import site.nomoreparties.stellarburgers.RegisterPage;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;


public class LoginTest {

    User user = new User("ulanovda@gmail.com", "password", "Денис");

    @Before
    public void setUp(){
        UserClient.registerUser(user);
    }

    @Test
    public void loginButtonTest() {
        HomePage homePage = open("https://stellarburgers.nomoreparties.site/", HomePage.class);
        LoginPage loginPage = homePage.waitAndPushLoginButton();

        webdriver().shouldHave(url("https://stellarburgers.nomoreparties.site/login"));
        loginPage.fullLogin("ulanovda@gmail.com", "password");

        webdriver().shouldHave(url("https://stellarburgers.nomoreparties.site/"));
    }

    @Test
    public void loginWithAccountButtonTest() {
        HomePage homePage = open("https://stellarburgers.nomoreparties.site/", HomePage.class);
        homePage.waitAndPushAccountButton();

        webdriver().shouldHave(url("https://stellarburgers.nomoreparties.site/login"));
        LoginPage loginPage = page(LoginPage.class);

        loginPage.fullLogin("ulanovda@gmail.com", "password");

        webdriver().shouldHave(url("https://stellarburgers.nomoreparties.site/"));
    }

    @Test
    public void loginFromRegisterPageTest() {
        HomePage homePage = open("https://stellarburgers.nomoreparties.site/", HomePage.class);
        LoginPage loginPage = homePage.waitAndPushLoginButton();
        webdriver().shouldHave(url("https://stellarburgers.nomoreparties.site/login"));
        RegisterPage registerPage = loginPage.waitAndPushRegisterLink();
        webdriver().shouldHave(url("https://stellarburgers.nomoreparties.site/register"));
        registerPage.waitAndPushLoginButton();
        webdriver().shouldHave(url("https://stellarburgers.nomoreparties.site/login"));

        loginPage.fullLogin("ulanovda@gmail.com", "password");

        webdriver().shouldHave(url("https://stellarburgers.nomoreparties.site/"));
    }

    @Test
    public void loginFromForgotPasswordPageTest() {
        HomePage homePage = open("https://stellarburgers.nomoreparties.site/", HomePage.class);
        LoginPage loginPage = homePage.waitAndPushLoginButton();
        ForgotPasswordPage forgotPasswordPage = loginPage.waitAndPushForgotPasswordLink();
        forgotPasswordPage.waitAndPushLoginButton();

        loginPage.fullLogin("ulanovda@gmail.com", "password");

        webdriver().shouldHave(url("https://stellarburgers.nomoreparties.site/"));
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(800);
        UserClient.deleteUser(user);
    }

}