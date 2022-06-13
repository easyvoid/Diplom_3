package site.nomoreparties.stellarburgers;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage {

    //Поле ввода Email
    public SelenideElement emailField = $x("//label[text()='Email']/following-sibling::input");

    //Метод ввода Email в поле
    public void setEmailField(String email) {
        emailField.setValue(email);
    }

    //Поле ввода Пароль
    public SelenideElement passwordField = $(byName("Пароль"));

    //Метод ввода Пароля в поле
    public void setPasswordField(String password) {
        passwordField.setValue(password);
    }

    //Кнопка Войти
    public SelenideElement loginButton = $x("//button[text()='Войти']");

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
    public static SelenideElement registerLink = $(byAttribute("href", "/register"));

    //Клик по ссылке Зарегистрироваться
    public RegisterPage waitAndPushRegisterLink() {
        registerLink.scrollTo();
        registerLink.shouldBe(visible, enabled);
        registerLink.click();
        return page(RegisterPage.class);
    }

    //Кнопка восстановить пароль
    public static SelenideElement forgotPasswordLink = $(byAttribute("href", "/forgot-password"));

    //Клик по ссылке восстановить пароль
    public ForgotPasswordPage waitAndPushForgotPasswordLink() {
        forgotPasswordLink.scrollTo();
        forgotPasswordLink.shouldBe(visible, enabled);
        forgotPasswordLink.click();
        return page(ForgotPasswordPage.class);
    }


}
