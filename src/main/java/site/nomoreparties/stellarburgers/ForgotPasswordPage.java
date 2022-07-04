package site.nomoreparties.stellarburgers;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class ForgotPasswordPage extends GeneralMethods{

    //Кнопка Войти
    private SelenideElement loginButton = $(byAttribute("href", "/login"));

    //Метод ожидания видимости кнопки и нажатия на неё для Логина
    public LoginPage waitAndPushLoginButton(){
        waitAndVisibleButton(loginButton);
        pushButton(loginButton);
        return page(LoginPage.class);
    }
}
