package ru.scooter.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.OrderPage;
import ru.scooter.helpers.TestBase;

import static com.codeborne.selenide.Selenide.open;

public class MainPageLinkTest extends TestBase {
    OrderPage orderPage = new OrderPage(); //private final

    @Test
    @DisplayName("Проверка корректности ссылки после клика на лого")
    void goToTheMainPageUsingTheLogoScooterIsCorrect() {
        open("order"); // заменить на енам
        orderPage.clickScooterLogo()
                .checkLinkPage();
    }
}
