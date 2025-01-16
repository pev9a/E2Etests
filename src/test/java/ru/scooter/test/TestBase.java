package ru.scooter.test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;



public class TestBase {

    public final String orderUrl = "https://qa-scooter.praktikum-services.ru/order";

    public final String yandexUrl = "https://yandex.ru";

    @BeforeAll
    static void beforeAll() {

        Configuration.baseUrl = "https://qa-scooter.praktikum-services.ru/";
        Configuration.browser = "firefox";
        Configuration.browserSize = "1920x1080";

    }
}