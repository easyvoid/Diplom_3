package site.nomoreparties.stellarburgers.ChromeBrowser;

import api.User;
import api.UserClient;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.*;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;


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

        String actualEmail = checkAccountProfile();
        assertEquals("ulanovda@gmail.com",actualEmail);
    }

    @Test
    public void loginWithAccountButtonTest() {
        HomePage homePage = open("https://stellarburgers.nomoreparties.site/", HomePage.class);
        homePage.waitAndPushAccountButton();

        webdriver().shouldHave(url("https://stellarburgers.nomoreparties.site/login"));
        LoginPage loginPage = page(LoginPage.class);

        loginPage.fullLogin("ulanovda@gmail.com", "password");

        webdriver().shouldHave(url("https://stellarburgers.nomoreparties.site/"));

        String actualEmail = checkAccountProfile();
        assertEquals("ulanovda@gmail.com",actualEmail);
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

        String actualEmail = checkAccountProfile();
        assertEquals("ulanovda@gmail.com",actualEmail);
    }

    @Test
    public void loginFromForgotPasswordPageTest() {
        HomePage homePage = open("https://stellarburgers.nomoreparties.site/", HomePage.class);
        LoginPage loginPage = homePage.waitAndPushLoginButton();
        ForgotPasswordPage forgotPasswordPage = loginPage.waitAndPushForgotPasswordLink();
        forgotPasswordPage.waitAndPushLoginButton();

        loginPage.fullLogin("ulanovda@gmail.com", "password");

        webdriver().shouldHave(url("https://stellarburgers.nomoreparties.site/"));

        String actualEmail = checkAccountProfile();
        assertEquals("ulanovda@gmail.com",actualEmail);
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(800);
        UserClient.deleteUser(user);
    }

    @Step("Возвращает Email из Личного Кабинета")
    public String checkAccountProfile() {
        HomePage homePage = page(HomePage.class);
        AccountProfilePage accountProfilePage = homePage.waitAndPushAccountButton();
        return accountProfilePage.checkFieldValue(accountProfilePage.loginEmailField);
    }
}