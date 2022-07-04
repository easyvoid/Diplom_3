package api;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;


import static api.RequestSpec.getBaseSpec;
import static io.restassured.RestAssured.given;

public class UserClient {

    @Step("Запрос на создание пользователя: {user}")
    public void registerUser(User user) {
        given()
                .spec(getBaseSpec())
                .body(user)
                .when()
                .post("/api/auth/register")
                .then().log().all();
    }

    @Step("Запрос на авторизацию пользователя: {user}, который возвращает его accessToken и refreshToken")
    public ValidatableResponse loginUser(User user) {
        return given()
                .spec(getBaseSpec())
                .body(user)
                .when()
                .post("/api/auth/login")
                .then().log().all();
    }

    @Step("Запрос на удаление пользователя: {user} по его accessToken")
    public void deleteUser(User user) {
        String accessToken = loginUser(user).and().extract().body().path("accessToken");
        given()
                .spec(getBaseSpec())
                .header("Authorization", accessToken)
                .when()
                .delete("/api/auth/user")
                .then().log().all();
    }
}

