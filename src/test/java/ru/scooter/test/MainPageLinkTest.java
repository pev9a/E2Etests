package ru.scooter.test;



import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;



public class MainPageLinkTest extends TestBase{

    @Test
    void goToTheMainPageUsingTheLogoScooterIsCorrect() {
        open(orderUrl);
        $("#rcc-confirm-button").click();

        $(".Header_LogoScooter__3lsAR").click();
        webdriver().shouldNotHave(url(yandexUrl));
        webdriver().shouldHave(url(baseUrl));

    }
}
