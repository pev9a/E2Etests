package ru.scooter.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.OrderPage;
import ru.scooter.Configuration.TestBase;

import static com.codeborne.selenide.Selenide.open;
import static ru.scooter.enums.Links.ORDER;

public class IncorrectDataTest extends TestBase {
    private final OrderPage orderPage = new OrderPage();

    @Test
    @DisplayName("Проверка заказа самоката с введением некорректных данных")
    void orderWithIncorrectData(){
        open(ORDER.getLink());
        orderPage.settingAnIncorrectAddressAndCheckingPageErrors()
                .firstPage()
                .settingDateAndTryingPlaceAnOrder()
                .settingRentalPeriodAndTryingPlaceAnOrder();
    }
}
