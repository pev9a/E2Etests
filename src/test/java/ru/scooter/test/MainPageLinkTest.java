package ru.scooter.test;

import org.junit.jupiter.api.Test;
import pageObjects.OrderPage;
import ru.scooter.helpers.TestBase;

public class MainPageLinkTest extends TestBase {
    OrderPage orderPage = new OrderPage();

    @Test
    void goToTheMainPageUsingTheLogoScooterIsCorrect() {

        orderPage.orderOpenPage()
                .clickScooterLogo()
                .checkLinkPage();

    }

}
