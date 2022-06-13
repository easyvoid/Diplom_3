package site.nomoreparties.stellarburgers.ChromeBrowser;

import api.User;
import api.UserClient;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.AccountProfilePage;
import site.nomoreparties.stellarburgers.HomePage;
import site.nomoreparties.stellarburgers.LoginPage;
import site.nomoreparties.stellarburgers.RegisterPage;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;
import static org.junit.Assert.assertEquals;

public class ExitButtonTest {

    User user = new User("ulanovda@gmail.com", "password", "Денис");

    @Before
    public void setUp() {
        UserClient.registerUser(user);

        HomePage homePage = open("https://stellarburgers.nomoreparties.site/", HomePage.class);
        homePage.waitAndPushLoginButton();
        loginUser("ulanovda@gmail.com", "password");
    }

    @Test
    public void exitButtonTest() {
        HomePage homePage = page(HomePage.class);
        AccountProfilePage accountProfilePage = homePage.waitAndPushAccountButton();
        HomePage.loginButton.should(disappear);
        accountProfilePage.waitAndPushExitButton();
        webdriver().shouldHave(url("https://stellarburgers.nomoreparties.site/login"));
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(800);
        UserClient.deleteUser(user);
    }

    @Step("Логин пользователя")
    public static void loginUser(String email, String password) {
        LoginPage loginPage = page(LoginPage.class);
        loginPage.fullLogin(email, password);
        loginPage.loginButton.should(disappear);
    }
}
