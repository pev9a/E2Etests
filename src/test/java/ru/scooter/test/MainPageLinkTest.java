package ru.scooter.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.OrderPage;
import ru.scooter.Configuration.TestBase;

import static com.codeborne.selenide.Selenide.open;
import static ru.scooter.enums.Links.ORDER;

public class MainPageLinkTest extends TestBase {
    private final OrderPage orderPage = new OrderPage();

    @Test
    @DisplayName("Проверка корректности ссылки после клика на лого")
    void goToTheMainPageUsingTheLogoScooterIsCorrect() {
        open(ORDER.getLink());
        orderPage.clickScooterLogo()
                .checkLinkPage();
    }
}
