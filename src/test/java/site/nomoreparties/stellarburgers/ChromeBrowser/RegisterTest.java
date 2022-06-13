package site.nomoreparties.stellarburgers.ChromeBrowser;

import api.User;
import api.UserClient;
import io.qameta.allure.Step;
import org.junit.Test;
import site.nomoreparties.stellarburgers.AccountProfilePage;
import site.nomoreparties.stellarburgers.HomePage;
import site.nomoreparties.stellarburgers.LoginPage;
import site.nomoreparties.stellarburgers.RegisterPage;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;


public class RegisterTest {

    User user = new User("ulanovda@gmail.com", "password", "Денис");

    @Test
    public void registerPositiveTest() throws InterruptedException {
        HomePage homePage = open("https://stellarburgers.nomoreparties.site/", HomePage.class);
        LoginPage loginPage = homePage.waitAndPushLoginButton();

        RegisterPage registerPage = loginPage.waitAndPushRegisterLink();

        registerPage.fullRegister("Денис", "ulanovda@gmail.com", "password");

        webdriver().shouldHave(url("https://stellarburgers.nomoreparties.site/login"));

        deleteUserApi();
    }

    @Test
    public void registerShortPasswordTest() {
        HomePage homePage = open("https://stellarburgers.nomoreparties.site/", HomePage.class);
        LoginPage loginPage = homePage.waitAndPushLoginButton();

        RegisterPage registerPage = loginPage.waitAndPushRegisterLink();

        registerPage.fullRegister("Денис", "ulanovda@gmail.com", "paswo");

        registerPage.passwordErrorVisible();
    }

    @Step("Удаление пользователя через API")
    public void deleteUserApi() throws InterruptedException {
        Thread.sleep(800);
        UserClient.deleteUser(user);
    }
}