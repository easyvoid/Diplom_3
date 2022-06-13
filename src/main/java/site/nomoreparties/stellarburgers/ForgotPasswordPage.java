package site.nomoreparties.stellarburgers;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class ForgotPasswordPage {

    //Кнопка Войти
    public SelenideElement loginButton = $(byAttribute("href", "/login"));

    //Метод скрола и ожидания появления элемента (кнопки)
    public void waitAndVisibleButton(SelenideElement element){
        element.scrollTo();
        element.shouldBe(visible, enabled);
    }

    //Метод нажатия на кнопку
    public void pushButton(SelenideElement element){
        element.click();
    }

    //Метод ожидания видимости кнопки и нажатия на неё для Логина
    public LoginPage waitAndPushLoginButton(){
        waitAndVisibleButton(loginButton);
        pushButton(loginButton);
        return page(LoginPage.class);
    }
}
