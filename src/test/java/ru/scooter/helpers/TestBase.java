package ru.scooter.helpers;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    @BeforeAll
    static void beforeAll() {

        Configuration.baseUrl = "https://qa-scooter.praktikum-services.ru/";
        Configuration.browser = "firefox";
        Configuration.browserSize = "1920x1080";

    }

}