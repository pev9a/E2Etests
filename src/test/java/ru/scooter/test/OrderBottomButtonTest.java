package ru.scooter.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pageObjects.OrderPage;
import ru.scooter.helpers.TestData;

public class OrderBottomButtonTest extends TestData {
    OrderPage orderPage = new OrderPage();

    @Test
    @DisplayName("Проверка заказа самоката из кнопки в середине страницы")
    void orderBottomMenuButtonTest(){
        orderPage.clickBottomMenuButton()
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
