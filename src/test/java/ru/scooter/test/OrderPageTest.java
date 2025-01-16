package ru.scooter.test;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class OrderPageTest extends TestBase{

    @Test
    void orderTopMenuButtonTest() {

        open(baseUrl);
        $("#rcc-confirm-button").click();
        $(".Button_Button__ra12g").click();

        $("input[placeholder=\"* Имя\"]").setValue("Владимир");
        $("input[placeholder=\"* Фамилия\"]").setValue("Иванов");
        $("input[placeholder=\"* Адрес: куда привезти заказ\"]").setValue("Москва, ул. Пушкина, 47");
        $("input[placeholder=\"* Станция метро\"]").click();
        $(byText("Фрунзенская")).click();
        $("input[placeholder=\"* Телефон: на него позвонит курьер\"]").setValue("+79194532558");
        $(".Button_Button__ra12g.Button_Middle__1CSJM").click();

        $(".react-datepicker__input-container").click();
        $(".Input_Input__1iN_Z.Input_Responsible__1jDKN.react-datepicker-ignore-onclickoutside").setValue("06.01.2025");
        $(".Order_Header__BZXOb").click();
//        $(".react-datepicker__day.react-datepicker__day--006").click();
        $(".Dropdown-root").click();
        $(byText("трое суток")).click();
        $(byText("чёрный жемчуг")).click();
        $("input[placeholder=\"Комментарий для курьера\"]").setValue("Позвонить перед доставкой");
        $(".Order_Buttons__1xGrp").$(byText("Заказать")).click();
        $(".Order_Modal__YZ-d3").$(byText("Да")).click();

        $(".Order_Modal__YZ-d3").should(appear);
        $(".Order_ModalHeader__3FDaJ").shouldHave(text("Заказ оформлен"));

        $(".Order_NextButton__1_rCA").$(byText("Посмотреть статус")).click();
        $(".Track_OrderInfo__2fpDL").shouldHave(text("Владимир"),
                text("Иванов"),
                text("Москва, ул. Пушкина, 47"),
                text("+79194532558"));

    }

    @Test
    void OrderBottomMenuButtonTest() {

        open(baseUrl);
        $("#rcc-confirm-button").click();
        $(".Home_FinishButton__1_cWm").scrollIntoView(false);
        $(".Home_FinishButton__1_cWm").$(byText("Заказать")).click();

        $("input[placeholder=\"* Имя\"]").setValue("Владимир");
        $("input[placeholder=\"* Фамилия\"]").setValue("Иванов");
        $("input[placeholder=\"* Адрес: куда привезти заказ\"]").setValue("Москва, ул. Пушкина, 47");
        $("input[placeholder=\"* Станция метро\"]").click();
        $(byText("Фрунзенская")).click();
        $("input[placeholder=\"* Телефон: на него позвонит курьер\"]").setValue("+79194532558");
        $(".Button_Button__ra12g.Button_Middle__1CSJM").click();

        $(".react-datepicker__input-container").click();
        $(".Input_Input__1iN_Z.Input_Responsible__1jDKN.react-datepicker-ignore-onclickoutside").setValue("06.01.2025");
        $(".Order_Header__BZXOb").click();
//        $(".react-datepicker__day.react-datepicker__day--006").click();
        $(".Dropdown-root").click();
        $(byText("трое суток")).click();
        $(byText("чёрный жемчуг")).click();
        $("input[placeholder=\"Комментарий для курьера\"]").setValue("Позвонить перед доставкой");
        $(".Order_Buttons__1xGrp").$(byText("Заказать")).click();
        $(".Order_Modal__YZ-d3").$(byText("Да")).click();

        $(".Order_Modal__YZ-d3").should(appear);
        $(".Order_ModalHeader__3FDaJ").shouldHave(text("Заказ оформлен"));

        $(".Order_NextButton__1_rCA").$(byText("Посмотреть статус")).click();
        $(".Track_OrderInfo__2fpDL").shouldHave(text("Владимир"),
                text("Иванов"),
                text("Москва, ул. Пушкина, 47"),
                text("+79194532558"));

    }

}


