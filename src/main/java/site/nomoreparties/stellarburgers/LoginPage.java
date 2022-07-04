package site.nomoreparties.stellarburgers;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage extends GeneralMethods{

    //Поле ввода Email
    private SelenideElement emailField = $x("//label[text()='Email']/following-sibling::input");

        //Метод ввода Email в поле
        public void setEmailField(String email) {
            emailField.setValue(email);
        }

    //Поле ввода Пароль
    private SelenideElement passwordField = $(byName("Пароль"));

        //Метод ввода Пароля в поле
        public void setPasswordField(String password) {
            passwordField.setValue(password);
        }

    //Кнопка Войти
    private SelenideElement loginButton = $x("//button[text()='Войти']");

        //Метод проверки отсутствия кнопки логина
        public void loginButtonShouldDisappear(){
            buttonShouldDisappear(loginButton);
        }

    //Полный метод логина
    public void fullLogin(String email, String password) {
        emailField.shouldBe(visible);
        passwordField.shouldBe(visible);
        setEmailField(email);
        setPasswordField(password);
        loginButton.shouldBe(visible, enabled);
        loginButton.click();
    }

    //Ссылка Зарегистрироваться
    private SelenideElement registerLink = $(byAttribute("href", "/register"));

    //Клик по ссылке Зарегистрироваться
    public RegisterPage waitAndPushRegisterLink() {
        waitAndVisibleButton(registerLink);
        pushButton(registerLink);
        return page(RegisterPage.class);
    }

    //Кнопка восстановить пароль
    private SelenideElement forgotPasswordLink = $(byAttribute("href", "/forgot-password"));

    //Клик по ссылке восстановить пароль
    public ForgotPasswordPage waitAndPushForgotPasswordLink() {
        waitAndVisibleButton(forgotPasswordLink);
        pushButton(forgotPasswordLink);
        return page(ForgotPasswordPage.class);
    }

    @Step("Логин пользователя")
    public void loginUser(String email, String password) {
        LoginPage loginPage = page(LoginPage.class);
        loginPage.fullLogin(email, password);
        loginPage.loginButtonShouldDisappear();
        HomePage homePage = page(HomePage.class);
        homePage.loginButtonShouldDisappear();
    }
}
