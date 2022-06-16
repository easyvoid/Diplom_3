package site.nomoreparties.stellarburgers;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;

public class GeneralMethods {
    //Метод скрола и ожидания появления элемента (кнопки)
    public void waitAndVisibleButton(SelenideElement element){
        element.scrollTo();
        element.shouldBe(visible, enabled);
    }

    //Метод нажатия на кнопку
    public void pushButton(SelenideElement element){
        element.click();
    }
}
