package ru.scooter.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.OrderPage;
import ru.scooter.Configuration.TestBase;

public class OrderMiddleButtonTest extends TestBase {
    private final OrderPage orderPage = new OrderPage();

    @Test
    @DisplayName("Проверка заказа самоката из кнопки в середине страницы")
    void orderMiddleMenuButtonTest(){
        orderPage.clickMiddleMenuButton()
                .firstPage()
                .secondPage()
                .placingAndCheckingAnOrder();
    }
}
