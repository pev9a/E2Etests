package ru.scooter.helpers;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import pageObjects.MainPage;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;

public class TestBase {
    protected static MainPage mainPage = new MainPage();

    @BeforeEach
    void beforeEach() {
        baseUrl = "https://qa-scooter.praktikum-services.ru/";
        Configuration.browser = "firefox";
        Configuration.browserSize = "1920x1080";

        open(baseUrl);
        mainPage.acceptCookies();
    }

    @AfterEach
    void afterEach(){
        Selenide.closeWebDriver();
    }
}