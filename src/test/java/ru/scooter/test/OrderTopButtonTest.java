package ru.scooter.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.OrderPage;
import ru.scooter.Configuration.TestBase;

public class OrderTopButtonTest extends TestBase {
    OrderPage orderPage = new OrderPage(); //private final

    @Test
    @DisplayName("Проверка заказа самоката из кнопки в верхнем меню")
    void orderTopMenuButtonTest(){ // обьеднить методы по смыслу для сокращения степов
        orderPage.clickTopMenuButton()
                .firstPage()
                .secondPage()
                .placingAndCheckingAnOrder();
    }
}
