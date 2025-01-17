package ru.scooter.helpers;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {

    @BeforeEach
    void beforeEach() {

        Configuration.baseUrl = "https://qa-scooter.praktikum-services.ru/";
        Configuration.browser = "firefox";
        Configuration.browserSize = "1920x1080";

    }

    @AfterEach
    void afterEach(){

        Selenide.closeWebDriver();

    }

}