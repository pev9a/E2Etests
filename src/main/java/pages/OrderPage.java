package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.Calendar;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;
import static pages.testData.TestData.*;

public class OrderPage {
    Calendar calendarComponent = new Calendar();

    private final SelenideElement
            firstNameInput = $("input[placeholder='* Имя']"),
            lastNameInput = $("input[placeholder='* Фамилия']"),
            addressInput = $("input[placeholder='* Адрес: куда привезти заказ']"),
            telephoneNumberInput = $("input[placeholder='* Телефон: на него позвонит курьер']"),
            commentInput = $("input[placeholder='Комментарий для курьера']"),
            metroStation = $("input[placeholder='* Станция метро']"),
            buttonNext = $x("//*[contains(text(),'Далее')]"),
            rentPeriod = $(".Dropdown-arrow"),
            buttonYesInOrder = $x("//*[contains(text(),'Да')]"),
            errorMessage = $(".Input_Visible___syz6"),
            scooterLogo = $(".Header_LogoScooter__3lsAR"),
            confirmWindow = $(".Order_Modal__YZ-d3"),
            confirmMessage = $(".Order_ModalHeader__3FDaJ"),
            errorAddressMessage = $(".Order_Form__17u6u"),
            buttonViewStatus = $x("//*[contains(text(),'Посмотреть статус')]"),
            completedOrderWindow = $(".Track_OrderInfo__2fpDL");

    private final ElementsCollection
            buttonOrderInOrder = $$("button.Button_Button__ra12g.Button_Middle__1CSJM"),
            orderButtons = $$(byText("Заказать")),
            metroStationSelection = $$("[role='menuitem']"),
            rentPeriodSelection = $$(".Dropdown-option"),
            setColorSelection = $$("label");

    @Step("Заказать самокат через кнопку в верхней правой части сайта")
    public OrderPage clickTopMenuButton(){
        orderButtons.get(0).click();
        return this;
    }

    @Step("Заказать самокат через кнопку в середине сайта")
    public OrderPage clickMiddleMenuButton(){
        orderButtons.get(1).click();
        return this;
    }

    @Step("Установка значения имени в форму")
    public OrderPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    @Step("Установка значения фамилии в форму")
    public OrderPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    @Step("Установка значения адреса в форму")
    public OrderPage setAddress(String value) {
        addressInput.setValue(value);
        return this;
    }

    @Step("Установка значения номера в форму")
    public OrderPage setTelephoneNumber(String value) {
        telephoneNumberInput.setValue(value);
        return this;
    }

    @Step("Установка даты")
    public OrderPage setDeliveryDate(String value) {
        calendarComponent.setDate(value);
        return this;
    }

    @Step("Очистка поля ввода даты")
    public OrderPage removeDateDelivery() {
        calendarComponent.removeDate();
        return this;
    }

    @Step("Установка значения комментария для курьера")
    public void setComment(String value) {
        commentInput.setValue(value);
    }

    @Step("Установка значения станции метро в форму")
    public OrderPage setMetroStation(String value){
        metroStation.click();
        metroStationSelection.findBy(text(value)).click();
        return this;
    }

    @Step("Метод нажатия по кнопке 'Далее' в заказе")
    public OrderPage clickButtonNext(){
        buttonNext.click();
        return this;
    }

    @Step("Метод нажатия на поле ввода и установка количества суток аренды")
    public OrderPage setRentalPeriod(String value){
        rentPeriod.click();
        rentPeriodSelection.findBy(text(value)).click();
        return this;
    }

    @Step("Установка значения цвета самоката")
    public OrderPage setColor(String value){
        setColorSelection.findBy(text(value)).click();
        return this;
    }

    @Step("Метод заказа самоката с полностью заполненной формой и дальнейшее его подтверждение")
    public OrderPage placeAnOrder(){
        buttonOrderInOrder.get(1).click();
        buttonYesInOrder.click();
        return this;
    }

    @Step("Метод нажатия по кнопке 'Заказать' в заказе")
    public OrderPage orderButtonInOrder(){
        buttonOrderInOrder.get(1).click();
        return this;
    }

    @Step("Проверка подтверждения создания заказа")
    public OrderPage checkConfirmWindow(){
        confirmWindow.should(appear);
        confirmMessage.shouldHave(text("Заказ оформлен"));
        return this;
    }

    @Step("Проверка сообщения об ошибке")
    public OrderPage checkErrorMessage(){
        errorMessage.shouldHave(visible);
        return this;
    }

    @Step("Проверка сообщения о неккоректном адресе")
    public void checkCorrectAddress(){
        errorAddressMessage.shouldHave(text("Введите корректный адрес"));
    }

    @Step("Проверка оформленного заказа")
    public void checkCompleteOrder(){
        buttonViewStatus.click();
        completedOrderWindow.shouldHave(text(FIRST_NAME.getText()),
                text(LAST_NAME.getText()),
                text(ADDRESS.getText()),
                text(PHONE_NUMBER.getText()));
    }

    @Step("Проверка неоформленного заказа")
    public void checkNotCompleteOrder(){
        confirmWindow.shouldNotHave(appear);
    }

    @Step("Метод нажатия по логотипу 'Самокат'")
    public OrderPage clickScooterLogo(){
        scooterLogo.click();
        return this;
    }

    @Step("Проверка ссылки перенаправления")
    public void checkLinkPage(){
        webdriver().shouldHave(url(baseUrl));
    }

    @Step("Метод заполнения параметров первой страницы заказа")
    public OrderPage firstPage(){
                setFirstName(FIRST_NAME.getText())
                .setLastName(LAST_NAME.getText())
                .setAddress(ADDRESS.getText())
                .setMetroStation(SUBWAY_STATION.getText())
                .setTelephoneNumber(PHONE_NUMBER.getText())
                .clickButtonNext();
        return this;
    }

    @Step("Метод заполнения параметров второй страницы заказа")
    public OrderPage secondPage(){
                setDeliveryDate(DATE.getText())
                .setRentalPeriod(RENTAL_PERIOD.getText())
                .setColor(SCOOTER_COLOR.getText())
                .setComment(COMMENT.getText());
        return this;
    }

    @Step("Метод оформления и проверки заказа")
    public void placingAndCheckingAnOrder(){
                placeAnOrder()
                .checkConfirmWindow()
                .checkCompleteOrder();
    }

    @Step("Метод установки неккоректного адреса и проверка сообщения об ошибки страницы")
    public OrderPage settingAnIncorrectAddressAndCheckingPageErrors(){
                clickButtonNext()
                .checkErrorMessage()
                .setAddress(INCORRECT_ADDRESS.getText())
                .checkCorrectAddress();
        return this;
    }

    @Step("Метод установки даты 'Когда привезти самокат' и попытка сделать заказ без заполнения формы 'Срок аренды'")
    public OrderPage settingDateAndTryingPlaceAnOrder(){
                setDeliveryDate(DATE.getText())
                .orderButtonInOrder()
                .checkNotCompleteOrder();
        return this;
    }

    @Step("Метод установки 'Срок аренды' и попытка сделать заказ без заполнения формы 'Когда привезти самокат'")
    public void settingRentalPeriodAndTryingPlaceAnOrder(){
                removeDateDelivery()
                .setRentalPeriod(RENTAL_PERIOD.getText())
                .orderButtonInOrder()
                .checkNotCompleteOrder();// Ошибки не выдает, но заказ создать не получается.
    }
}


