package ru.scooter.test;

import org.junit.jupiter.api.Test;
import pageObjects.MainPage;
import pageObjects.OrderPage;
import ru.scooter.helpers.TestBase;

public class OrderTopButtonTest extends TestBase {
    MainPage mainPage = new MainPage();
    OrderPage orderPage = new OrderPage();

    private final String name = "Владимир";
    private final String lastname = "Иванов";
    private final String address = "Москва, ул. Пушкина, 47";
    private final String metro = "Фрунзенская";
    private final String phone = "+79194532558";
    private final String date = "06.01.2025";
    private final String rent = "трое суток";
    private final String color = "чёрный жемчуг";
    private final String comment = "Позвонить перед доставкой";

    //аннотации везде
    @Test
    void orderTopMenuButtonTest(){
        mainPage.openPage();
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
