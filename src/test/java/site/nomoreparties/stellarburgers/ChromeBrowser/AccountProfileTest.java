package site.nomoreparties.stellarburgers.ChromeBrowser;

import api.User;
import api.UserClient;
import io.qameta.allure.Step;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.HomePage;
import site.nomoreparties.stellarburgers.LoginPage;
import site.nomoreparties.stellarburgers.RegisterPage;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;


public class AccountProfileTest {

    User user = new User("ulanovda@gmail.com", "password", "Денис");

    @Before
    public void setUp(){
        UserClient.registerUser(user);
    }

    @Test
    public void pushAccountButtonNotAuthTest() {
        HomePage homePage = open("https://stellarburgers.nomoreparties.site/", HomePage.class);
        homePage.waitAndPushAccountButton();

        webdriver().shouldHave(url("https://stellarburgers.nomoreparties.site/login"));
    }

    @Test
    public void pushAccountButtonAuthTest() {
        HomePage homePage = open("https://stellarburgers.nomoreparties.site/", HomePage.class);
        homePage.waitAndPushLoginButton();
        loginUser("ulanovda@gmail.com", "password");

        webdriver().shouldHave(url("https://stellarburgers.nomoreparties.site/"));

        homePage.waitAndPushAccountButton();
        webdriver().shouldHave(url("https://stellarburgers.nomoreparties.site/account/profile"));
    }

    @After
    public void tearDown() throws InterruptedException {
        UserClient.deleteUser(user);
        Thread.sleep(800);
    }

    @Step("Логин пользователя")
    public void loginUser(String email, String password) {
        LoginPage loginPage = page(LoginPage.class);
        loginPage.fullLogin(email, password);
        loginPage.loginButton.should(disappear);
    }

}