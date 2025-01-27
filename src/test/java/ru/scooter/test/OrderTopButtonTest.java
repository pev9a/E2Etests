package ru.scooter.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.OrderPage;
import ru.scooter.Configuration.TestBase;

public class OrderTopButtonTest extends TestBase {
    private final OrderPage orderPage = new OrderPage();

    @Test
    @DisplayName("Проверка заказа самоката из кнопки в верхнем меню")
    void orderTopMenuButtonTest(){
        orderPage.clickTopMenuButton()
                .firstPage()
                .secondPage()
                .placingAndCheckingAnOrder();
    }
}
