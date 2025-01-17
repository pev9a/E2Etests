package ru.scooter.test;

import org.junit.jupiter.api.Test;
import pageObjects.OrderPage;
import ru.scooter.helpers.TestBase;

public class IncorrectDataTest extends TestBase {
    OrderPage orderPage = new OrderPage();

    private final String incorrectAddress = "2";
    private final String name = "Максим";
    private final String lastname = "Ишков";
    private final String address = "Москва, ул. Гоголя, 52";
    private final String metro = "Спортивная";
    private final String phone = "+79191332466";
    private final String date = "25.01.2025";
    private final String rent = "сутки";

    @Test
    void orderWithIncorrectData(){
        orderPage.orderOpenPage()
                .clickButtonNext()
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
