package site.nomoreparties.stellarburgers.ChromeBrowser;

import api.User;
import api.UserClient;
import org.junit.Test;
import site.nomoreparties.stellarburgers.HomePage;
import site.nomoreparties.stellarburgers.LoginPage;
import site.nomoreparties.stellarburgers.RegisterPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;


public class RegisterTest {

    User user = new User("ulanovda@gmail.com", "password", "Денис");

    @Test
    public void registerPositiveTest() {
        HomePage homePage = open("https://stellarburgers.nomoreparties.site/", HomePage.class);
        LoginPage loginPage = homePage.waitAndPushLoginButton();

        RegisterPage registerPage = loginPage.waitAndPushRegisterLink();

        registerPage.fullRegister("Денис", "ulanovda@gmail.com", "password");

        webdriver().shouldHave(url("https://stellarburgers.nomoreparties.site/login"));

        UserClient.deleteUser(user);
    }

    @Test
    public void registerShortPasswordTest() {
        HomePage homePage = open("https://stellarburgers.nomoreparties.site/", HomePage.class);
        LoginPage loginPage = homePage.waitAndPushLoginButton();

        RegisterPage registerPage = loginPage.waitAndPushRegisterLink();

        registerPage.fullRegister("Денис", "ulanovda@gmail.com", "paswo");

        registerPage.passwordErrorVisible();
    }

}