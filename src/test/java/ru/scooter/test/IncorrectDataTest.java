package ru.scooter.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.OrderPage;
import ru.scooter.helpers.TestData;

import static com.codeborne.selenide.Selenide.open;

public class IncorrectDataTest extends TestData {
    OrderPage orderPage = new OrderPage(); //private final

    @Test
    @DisplayName("Проверка заказа самоката с введением некорректных данных")
    void orderWithIncorrectData(){
        open("order");//ордер эндпоинт вынести в енам Links, и открывать через open(Links.OrderEndpoint.getLink()); к примеру и через ламбоковские аннотации пиздануть типа того
        /*
         @AllArgsConstructor
    @Getter
    public enum ConstructorOption {
        ORDER("/order")

        private final String link;
    }*/
        orderPage.clickButtonNext() //разделить на несколько методов которые обьединены по смыслу к примеру первые 3 метода обьединить
                // orderPage.firstPage(),
                // orderPage.secondPage(парметры от методов);
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
