package ru.scooter.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.OrderPage;
import ru.scooter.helpers.TestData;

public class OrderTopButtonTest extends TestData {
    OrderPage orderPage = new OrderPage(); //private final

    @Test
    @DisplayName("Проверка заказа самоката из кнопки в верхнем меню")
    void orderTopMenuButtonTest(){ // обьеднить методы по смыслу для сокращения степов
        orderPage.clickTopMenuButton()
                .setFirstName(name)
                .setLastName(lastname)
                .setAddress(address)
                .setMetroStation(metro)
                .setTelephoneNumber(phone)
                .clickButtonNext()
                .setDeliveryDate(date)
                .setRentalPeriod(rent)
                .setColor(color)
                .setComment(comment)
                .placeAnOrder()
                .checkConfirmWindow()
                .checkCompleteOrder();
    }
}
