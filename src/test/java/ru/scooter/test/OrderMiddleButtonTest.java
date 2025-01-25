package ru.scooter.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.OrderPage;
import ru.scooter.Configuration.TestBase;

public class OrderMiddleButtonTest extends TestBase {
    OrderPage orderPage = new OrderPage();//private final

    @Test
    @DisplayName("Проверка заказа самоката из кнопки в середине страницы")
    void orderBottomMenuButtonTest(){ //обьединить методы по смыслу для сокращения степов теста
        orderPage.clickMiddleMenuButton()
                .firstPage()
                .secondPage()
                .placingAndCheckingAnOrder();
    }
}
