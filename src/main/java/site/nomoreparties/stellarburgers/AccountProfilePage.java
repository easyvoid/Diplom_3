package site.nomoreparties.stellarburgers;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class AccountProfilePage extends GeneralMethods{

    //Поле Логин
    private SelenideElement loginEmailField = $x("//label[text()='Логин']/following-sibling::input");

    //Методи проверки значения поля Логин
    public String checkLoginFieldValue() {
        loginEmailField.scrollTo();
        loginEmailField.shouldBe(visible);
        return loginEmailField.getValue();
    }

    //Кнопка Выход
    private SelenideElement exitButton = $x("//button[text()='Выход']");

        //Метод ожидания видимости кнопки и нажатия на неё для Логина
        public void waitAndPushExitButton(){
            waitAndVisibleButton(exitButton);
            pushButton(exitButton);
        }
}
