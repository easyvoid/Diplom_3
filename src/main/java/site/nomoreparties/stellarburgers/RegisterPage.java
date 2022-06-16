package site.nomoreparties.stellarburgers;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class RegisterPage extends GeneralMethods{

        //Поле ввода Имя
        public SelenideElement nameField = $x("//label[text()='Имя']/following-sibling::input");

        //Метод ввода имени в поле Имя
        public void setNameField(String name){
            nameField.click();
            nameField.setValue(name);
        }

        //Поле ввода Email
        public SelenideElement emailField = $x("//label[text()='Email']/following-sibling::input");

        //Метод ввода имени в поле Email
        public void setEmailField(String email){
            emailField.click();
            emailField.setValue(email);
        }

        //Поле ввода Пароль
        public SelenideElement passwordField = $(byName("Пароль"));

        //Метод ввода имени в поле Пароль
        public void setPasswordField(String password){
            passwordField.click();
            passwordField.setValue(password);
        }

        //Кнопка зарегистрироваться
        public SelenideElement registerButton = $x("//button[text()='Зарегистрироваться']");

        //Метод ввода имени, почты и пароля для регистрации
        public void fullRegister(String name, String email, String password){
            nameField.shouldBe(visible);
            emailField.shouldBe(visible);
            passwordField.shouldBe(visible);
            setNameField(name);
            setEmailField(email);
            setPasswordField(password);
            registerButton.shouldBe(visible, enabled);
            registerButton.click();
        }

        //Ошибка Некорректный пароль
        public SelenideElement incorrectPasswordError = $x("//p[text()='Некорректный пароль']");

        //Метод проверки отображения ошибки о пароле
        public void passwordErrorVisible(){
            incorrectPasswordError.should(exist);
            incorrectPasswordError.shouldBe(visible);
            incorrectPasswordError.shouldHave(exactText("Некорректный пароль"));
        }

        //Кнопка Войти
        public SelenideElement loginButton = $(byAttribute("href", "/login"));

            //Метод ожидания видимости кнопки и нажатия на неё для Логина
            public void waitAndPushLoginButton(){
                waitAndVisibleButton(loginButton);
                pushButton(loginButton);
            }
}
