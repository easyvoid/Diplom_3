package site.nomoreparties.stellarburgers;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.page;

public class GeneralMethods {
    //Метод скрола и ожидания появления элемента (кнопки)
    public void waitAndVisibleButton(SelenideElement element) {
        element.scrollTo();
        element.should(exist);
        element.shouldBe(visible, enabled);
    }

    //Метод нажатия на кнопку
    public void pushButton(SelenideElement element){
        element.click();
    }

    //Метод проверки отсутствия кнопки
    public void buttonShouldDisappear (SelenideElement element){
        element.should(disappear);
    }
}
