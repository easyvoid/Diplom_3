package site.nomoreparties.stellarburgers.YandexBrowser;

import api.User;
import api.UserClient;
import io.qameta.allure.Step;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import site.nomoreparties.stellarburgers.*;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;
import static org.junit.Assert.assertEquals;

public class LoginTest {
    ChromeDriver driver;

    User user = new User("ulanovda@gmail.com", "password", "Денис");

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\yandexdriver.exe");
        driver = new ChromeDriver();
        setWebDriver(driver);

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
        driver.quit();
        Thread.sleep(800);
        UserClient.deleteUser(user);
    }
}