package ru.scooter.test;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class NegativeTest extends TestBase{

    @Test
    void orderWithIncorrectData(){

        open(orderUrl);
        $("#rcc-confirm-button").click();

        $(".Button_Button__ra12g.Button_Middle__1CSJM").click();
        $(".Input_Visible___syz6").shouldHave(visible);

        $("input[placeholder=\"* Адрес: куда привезти заказ\"]").setValue("12");
        $(".Button_Button__ra12g.Button_Middle__1CSJM").click();
        $(".Order_Form__17u6u").shouldHave(text("Введите корректный адрес"));

        $("input[placeholder=\"* Имя\"]").setValue("Владимир");
        $("input[placeholder=\"* Фамилия\"]").setValue("Иванов");
        $("input[placeholder=\"* Адрес: куда привезти заказ\"]").setValue("Москва, ул. Пушкина, 47");
        $("input[placeholder=\"* Станция метро\"]").click();
        $(byText("Фрунзенская")).click();
        $("input[placeholder=\"* Телефон: на него позвонит курьер\"]").setValue("+79194532558");
        $(".Button_Button__ra12g.Button_Middle__1CSJM").click();

        $(".react-datepicker__input-container").click();
        $(".react-datepicker__day.react-datepicker__day--006").click();

        $(".Order_Buttons__1xGrp").$(byText("Заказать")).click();
        $(".Order_Modal__YZ-d3").shouldNotHave(appear);// Ошибки не выдает, но заказ создать не получается.

        $(".react-datepicker__input-container").doubleClick();
        $(".Input_Input__1iN_Z.Input_Responsible__1jDKN.Input_Filled__1rDxs.react-datepicker-ignore-onclickoutside").sendKeys(Keys.BACK_SPACE);
        $(".Order_Header__BZXOb").click();

        $(".Dropdown-root").click();
        $(byText("сутки")).click();

        $(".Order_Buttons__1xGrp").$(byText("Заказать")).click();
        $(".Order_Modal__YZ-d3").shouldNotHave(appear);// Ошибки не выдает, но заказ создать не получается.

    }

}
