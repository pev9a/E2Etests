package ru.scooter.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pageObjects.OrderPage;
import ru.scooter.helpers.TestData;

public class OrderTopButtonTest extends TestData {
    OrderPage orderPage = new OrderPage();

    @Test
    @DisplayName("Проверка заказа самоката из кнопки в верхнем меню")
    void orderTopMenuButtonTest(){
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
