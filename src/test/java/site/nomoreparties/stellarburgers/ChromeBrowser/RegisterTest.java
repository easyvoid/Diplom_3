package site.nomoreparties.stellarburgers.ChromeBrowser;

import api.User;
import org.junit.After;
import org.junit.Test;
import site.nomoreparties.stellarburgers.*;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;


public class RegisterTest extends BaseTest {

    @Test
    public void registerPositiveTest() {
        HomePage homePage = open(homePageURL, HomePage.class);
        LoginPage loginPage = homePage.waitAndPushLoginButton();

        RegisterPage registerPage = loginPage.waitAndPushRegisterLink();

        registerPage.fullRegister(user.getName(), user.getEmail(), user.getPassword());

        webdriver().shouldHave(url(loginPageURL));
    }

    @Test
    public void registerShortPasswordTest() {
//        User userWithShortPassword = new User(user.getEmail(), gen.randomShortPassword(), user.getName());
//        не знаю какая реализация лучше, которая строкой выше или строкой ниже?
        User userWithShortPassword = new User().setPassword(gen.randomShortPassword()).setEmail(user.getEmail()).setName(user.getName());
        HomePage homePage = open(homePageURL, HomePage.class);
        LoginPage loginPage = homePage.waitAndPushLoginButton();

        RegisterPage registerPage = loginPage.waitAndPushRegisterLink();

        registerPage.fullRegister(userWithShortPassword.getName(), userWithShortPassword.getEmail(), userWithShortPassword.getPassword());

        registerPage.passwordErrorVisible();

        user = userWithShortPassword;
    }

    @After
    public void tearDown() throws InterruptedException {
        String body = client.loginUser(user).and().extract().body().path("accessToken");
        Thread.sleep(800);
        if (body != null) {
            client.deleteUser(user);
        }
    }
}