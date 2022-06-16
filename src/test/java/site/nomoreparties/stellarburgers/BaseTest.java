package site.nomoreparties.stellarburgers;

import api.User;
import api.UserClient;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Selenide.page;

public class BaseTest extends UserGeneration{

    protected String homePageURL = "https://stellarburgers.nomoreparties.site/";
    protected String loginPageURL = "https://stellarburgers.nomoreparties.site/login";
    protected String registerPageURL = "https://stellarburgers.nomoreparties.site/register";
    protected String profilePageURL = "https://stellarburgers.nomoreparties.site/account/profile";

    protected UserGeneration gen = new UserGeneration();
    protected User user = new User(gen.randomEmail(), gen.randomPassword(), gen.randomName());
    protected UserClient client = new UserClient();

    @Step("Логин пользователя")
    public void loginUser(String email, String password) {
        LoginPage loginPage = page(LoginPage.class);
        loginPage.fullLogin(email, password);
        loginPage.loginButton.should(disappear);
    }

    @Step("Возвращает Email из Личного Кабинета")
    public String checkAccountProfile() {
        HomePage homePage = page(HomePage.class);
        AccountProfilePage accountProfilePage = homePage.waitAndPushAccountButton();
        return accountProfilePage.checkLoginFieldValue();
    }
}
