package site.nomoreparties.stellarburgers;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class AccountProfilePage {

    //Поле Логин
    public SelenideElement loginEmailField = $x("//label[text()='Логин']/following-sibling::input");

    //Методи проверки значения поля
    public String checkFieldValue(SelenideElement element) {
        loginEmailField.scrollTo();
        loginEmailField.shouldBe(visible, enabled);
        return element.getValue();
    }

    //Кнопка Выход
    public SelenideElement exitButton = $x("//button[text()='Выход']");

        //Метод скрола и ожидания появления элемента (кнопки)
        public void waitAndVisibleButton(SelenideElement element){
            element.scrollTo();
            element.shouldBe(visible, Duration.ofSeconds(2));
        }

        //Метод нажатия на кнопку
        public void pushButton(SelenideElement element){
            element.click();
        }

        //Метод ожидания видимости кнопки и нажатия на неё для Логина
        public void waitAndPushExitButton(){
            waitAndVisibleButton(exitButton);
            pushButton(exitButton);
        }
}
