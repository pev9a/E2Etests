package ru.scooter.helpers;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import pages.MainPage;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;

public class TestBase { //это не хелперы а конфигурейшн
    protected static MainPage mainPage = new MainPage();

    @BeforeEach
    void beforeEach() {
        baseUrl = "https://qa-scooter.praktikum-services.ru/";
        Configuration.browser = "firefox";
        Configuration.browserSize = "1920x1080";

        open(baseUrl);
        mainPage.acceptCookies(); // вынести это в каждый тест в хук @BeforeEach, тк в реальном проекте возможны ситуации, когда куки ты уже пробросил и акцептить их не надо
    }

    @AfterEach
    void afterEach(){
        Selenide.closeWebDriver();
    }
}