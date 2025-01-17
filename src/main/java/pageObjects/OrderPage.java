package pageObjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;

public class OrderPage {

    public final String yandexUrl = "https://yandex.ru";

    public final String orderUrl = "https://qa-scooter.praktikum-services.ru/order";

    private final SelenideElement
            firstNameInput = $("input[placeholder=\"* Имя\"]"),
            lastNameInput = $("input[placeholder=\"* Фамилия\"]"),
            addressInput = $("input[placeholder=\"* Адрес: куда привезти заказ\"]"),
            telephoneNumberInput = $("input[placeholder=\"* Телефон: на него позвонит курьер\"]"),
            deliveryDateInput = $(".Input_Input__1iN_Z.Input_Responsible__1jDKN.react-datepicker-ignore-onclickoutside"),
            commentInput = $("input[placeholder=\"Комментарий для курьера\"]"),
            confirmCookiesButton = $("#rcc-confirm-button"),
            topMenuButton = $(".Button_Button__ra12g"),
            bottomMenuButton = $(".Home_FinishButton__1_cWm").$(byText("Заказать")),
            metroStation = $("input[placeholder=\"* Станция метро\"]"),
            buttonNext = $(".Button_Button__ra12g.Button_Middle__1CSJM"),
            dateDelivery = $(".react-datepicker__input-container"),
            rentPeriod = $(".Dropdown-root"),
            buttonOrderInOrder = $(".Order_Buttons__1xGrp").$(byText("Заказать")),
            buttonYesInOrder = $(".Order_Modal__YZ-d3").$(byText("Да")),
            errorMessage = $(".Input_Visible___syz6"),
            scooterLogo = $(".Header_LogoScooter__3lsAR");

    public OrderPage clickTopMenuButton(){
        topMenuButton.click();
        return this;
    }

    public OrderPage orderOpenPage(){
        open(orderUrl);
        confirmCookiesButton.click();
        return this;
    }

    public OrderPage clickBottomMenuButton(){
        bottomMenuButton.click();
        return this;
    }

    public OrderPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public OrderPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public OrderPage setAddress(String value) {
        addressInput.setValue(value);
        return this;
    }

    public OrderPage setTelephoneNumber(String value) {
        telephoneNumberInput.setValue(value);
        return this;
    }

    public OrderPage setDeliveryDate(String value) {
        dateDelivery.click();
        deliveryDateInput.setValue(value);
        $(".Order_Header__BZXOb").click();
        return this;
    }

    public OrderPage setComment(String value) {
        commentInput.setValue(value);
        return this;
    }

    public OrderPage setMetroStation(String value){
        metroStation.click();
        $(byText(value)).click();
        return this;
    }

    public OrderPage clickButtonNext(){
        buttonNext.click();
        return this;
    }

    public OrderPage setRentalPeriod(String value){
        rentPeriod.click();
        $(byText(value)).click();
        return this;
    }

    public OrderPage setColor(String value){
        $(byText(value)).click();
        return this;
    }

    public OrderPage placeAnOrder(){
        buttonOrderInOrder.click();
        buttonYesInOrder.click();
        return this;
    }

    public OrderPage orderButtonInOrder(){
        buttonOrderInOrder.click();
        return this;
    }

    public OrderPage checkConfirmWindow(){
        $(".Order_Modal__YZ-d3").should(appear);
        $(".Order_ModalHeader__3FDaJ").shouldHave(text("Заказ оформлен"));
        return this;
    }

    public OrderPage checkErrorMessage(){
        errorMessage.shouldHave(visible);
        return this;
    }

    public OrderPage checkCorrectAddress(){
        $(".Order_Form__17u6u").shouldHave(text("Введите корректный адрес"));
        return this;
    }

    public void checkCompleteOrder(){
        $(".Order_NextButton__1_rCA").$(byText("Посмотреть статус")).click();
        $(".Track_OrderInfo__2fpDL").shouldHave(text("Владимир"),
                text("Иванов"),
                text("Москва, ул. Пушкина, 47"),
                text("+79194532558"));
    }

    public OrderPage checkNotCompleteOrder(){
        $(".Order_Modal__YZ-d3").shouldNotHave(appear);
        return this;
    }

    public OrderPage removeDateDelivery(){
        $(".react-datepicker__input-container").click();
        for (int i = 0; i < 10; i++)
        { $(".Input_Input__1iN_Z.Input_Responsible__1jDKN.Input_Filled__1rDxs.react-datepicker-ignore-onclickoutside").sendKeys(Keys.BACK_SPACE); }
        $(".Order_Header__BZXOb").click();
        return this;
    }

    public OrderPage clickScooterLogo(){
        scooterLogo.click();
        return this;
    }

    public void checkLinkPage(){
        webdriver().shouldNotHave(url(yandexUrl));
        webdriver().shouldHave(url(baseUrl));
    }

}


