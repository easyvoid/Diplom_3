package site.nomoreparties.stellarburgers;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class ForgotPasswordPage extends GeneralMethods{

    //Кнопка Войти
    public SelenideElement loginButton = $(byAttribute("href", "/login"));

    //Метод скрола и ожидания появления элемента (кнопки)

    //Метод ожидания видимости кнопки и нажатия на неё для Логина
    public LoginPage waitAndPushLoginButton(){
        waitAndVisibleButton(loginButton);
        pushButton(loginButton);
        return page(LoginPage.class);
    }
}
