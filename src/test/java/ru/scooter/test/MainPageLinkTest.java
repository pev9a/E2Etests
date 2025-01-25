package ru.scooter.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.OrderPage;
import ru.scooter.Configuration.TestBase;

import static com.codeborne.selenide.Selenide.open;
import static ru.scooter.enums.Links.ORDER;

public class MainPageLinkTest extends TestBase {
    OrderPage orderPage = new OrderPage(); //private final

    @Test
    @DisplayName("Проверка корректности ссылки после клика на лого")
    void goToTheMainPageUsingTheLogoScooterIsCorrect() {
        open(ORDER.getLink()); // заменить на енам
        orderPage.clickScooterLogo()
                .checkLinkPage();
    }
}
