package site.nomoreparties.stellarburgers.YandexBrowser;

import api.User;
import api.UserClient;
import io.qameta.allure.Step;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import site.nomoreparties.stellarburgers.HomePage;
import site.nomoreparties.stellarburgers.LoginPage;
import site.nomoreparties.stellarburgers.RegisterPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;


public class RegisterTest {
    ChromeDriver driver;

    User user = new User("ulanovda@gmail.com", "password", "Денис");

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\yandexdriver.exe");
        driver = new ChromeDriver();
        setWebDriver(driver);
    }

    @After
    public void tearDown(){
        driver.quit();
    }

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