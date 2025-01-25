package ru.scooter.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.OrderPage;
import ru.scooter.Configuration.TestBase;

import static com.codeborne.selenide.Selenide.open;
import static ru.scooter.enums.Links.ORDER;

public class IncorrectDataTest extends TestBase {
    OrderPage orderPage = new OrderPage(); //private final

    @Test
    @DisplayName("Проверка заказа самоката с введением некорректных данных")
    void orderWithIncorrectData(){
        open(ORDER.getLink());//ордер эндпоинт вынести в енам Links, и открывать через open(Links.OrderEndpoint.getLink()); к примеру и через ламбоковские аннотации пиздануть типа того
        /*
         @AllArgsConstructor
    @Getter
    public enum ConstructorOption {
        ORDER("/order")

        private final String link;
    }*/
        orderPage.settingAnIncorrectAddressAndCheckingPageErrors()
                .firstPage()
                .settingDateAndTryingPlaceAnOrder()
                .settingRentalPeriodAndTryingPlaceAnOrder();
    }
}
