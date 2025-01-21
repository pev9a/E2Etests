package ru.scooter.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pageObjects.OrderPage;
import ru.scooter.helpers.TestData;

import static com.codeborne.selenide.Selenide.open;

public class IncorrectDataTest extends TestData {
    OrderPage orderPage = new OrderPage();

    @Test
    @DisplayName("Проверка заказа самоката с введением некорректных данных")
    void orderWithIncorrectData(){
        open("order");
        orderPage.clickButtonNext()
                .checkErrorMessage()
                .setAddress(incorrectAddress)
                .checkCorrectAddress()
                .setFirstName(name)
                .setLastName(lastname)
                .setAddress(address)
                .setMetroStation(metro)
                .setTelephoneNumber(phone)
                .clickButtonNext()
                .setDeliveryDate(date)
                .orderButtonInOrder()
                .checkNotCompleteOrder()
                .removeDateDelivery()
                .setRentalPeriod(rent)
                .orderButtonInOrder()
                .checkNotCompleteOrder();// Ошибки не выдает, но заказ создать не получается.
    }
}
