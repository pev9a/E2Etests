package ru.scooter.helpers;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;

public class TestBase {

    @BeforeEach
    void beforeEach() {
        baseUrl = "https://qa-scooter.praktikum-services.ru/";
        Configuration.browser = "firefox";
        Configuration.browserSize = "1920x1080";
        open(baseUrl);
        //прикрутить куки аппрув
    }

    @AfterEach
    void afterEach(){
        Selenide.closeWebDriver();
    }

}