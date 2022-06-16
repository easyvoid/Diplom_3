package site.nomoreparties.stellarburgers;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;

public class AccountProfilePage extends GeneralMethods{

    //Поле Логин
    public SelenideElement loginEmailField = $x("//label[text()='Логин']/following-sibling::input");

    //Методи проверки значения поля Логин
    public String checkLoginFieldValue() {
        loginEmailField.scrollTo();
        loginEmailField.shouldBe(visible);
        return loginEmailField.getValue();
    }

    //Кнопка Выход
    public SelenideElement exitButton = $x("//button[text()='Выход']");

        //Метод ожидания видимости кнопки и нажатия на неё для Логина
        public void waitAndPushExitButton(){
            waitAndVisibleButton(exitButton);
            pushButton(exitButton);
        }
}
