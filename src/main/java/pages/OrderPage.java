package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.Calendar;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;

public class OrderPage {
    Calendar calendarComponent = new Calendar();

    public final String yandexUrl = "https://yandex.ru"; //поч это тут? убрать в тест бейз

    private final SelenideElement
            firstNameInput = $("input[placeholder=\"* Имя\"]"), //исправить " на ' чтобы обойтись без экранирования
            lastNameInput = $("input[placeholder=\"* Фамилия\"]"),
            addressInput = $("input[placeholder=\"* Адрес: куда привезти заказ\"]"),
            telephoneNumberInput = $("input[placeholder=\"* Телефон: на него позвонит курьер\"]"),
            commentInput = $("input[placeholder=\"Комментарий для курьера\"]"),
            topMenuButton = $(".Button_Button__ra12g"),
            bottomMenuButton = $(".Home_FinishButton__1_cWm").$(byText("Заказать")), //сделать на XPATH
            metroStation = $("input[placeholder=\"* Станция метро\"]"),
            buttonNext = $(".Button_Button__ra12g.Button_Middle__1CSJM"),
            rentPeriod = $(".Dropdown-root"),
            buttonOrderInOrder = $(".Order_Buttons__1xGrp").$(byText("Заказать")),//сделать на XPATH
            buttonYesInOrder = $(".Order_Modal__YZ-d3").$(byText("Да")),//сделать на XPATH
            errorMessage = $(".Input_Visible___syz6"),
            scooterLogo = $(".Header_LogoScooter__3lsAR"),
            confirmWindow = $(".Order_Modal__YZ-d3"),
            confirmMessage = $(".Order_ModalHeader__3FDaJ"),
            errorAddressMessage = $(".Order_Form__17u6u"),
            buttonViewStatus = $(".Order_NextButton__1_rCA").$(byText("Посмотреть статус")),//сделать на XPATH
            completedOrderWindow = $(".Track_OrderInfo__2fpDL");

    @Step("Клик на кнопку заказа в верхней правой части сайта") //проблема в нейминге, должно быть "Заказать самокат через кнопку в верхней правой части сайта"
    public OrderPage clickTopMenuButton(){ //середина страницы то не bottom а middle, orderScooterByTopMenuButton
        topMenuButton.click();
        return this;
    }

    @Step("Клик на кнопку заказа в середине страницы сайта") //проблема в нейминге, должно быть "Заказать самокат через кнопку в середине сайта"
    public OrderPage clickBottomMenuButton(){
        bottomMenuButton.click();
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
    public OrderPage setComment(String value) {
        commentInput.setValue(value);
        return this;
    }

    @Step("Установка значения станции метро в форму")
    public OrderPage setMetroStation(String value){
        metroStation.click();
        $(byText(value)).click();
        return this;
    }/*сделай так ток переменная не х, а по смыслу и так везде где byText
    public OrderPage setMetroStation(String value) {
   *metroStation.click(); // Предположим, это открывает список станций
    SelenideElement x = $(byText(value)); // Присваиваем элемент переменной x
    x.click(); // Кликаем по элементу
    return this;
    }*/

    @Step("Клик по кнопке 'Далее'")
    public OrderPage clickButtonNext(){
        buttonNext.click();
        return this;
    }

    @Step("Клик на поле и установка количества суток аренды")
    public OrderPage setRentalPeriod(String value){
        rentPeriod.click();
        $(byText(value)).click();
        return this;
    }

    @Step("Установка значения цвета самоката")
    public OrderPage setColor(String value){
        $(byText(value)).click();
        return this;
    }

    @Step("Метод заказа самоката(Кнопка 'Заказать' -> Кнопка 'Да')") //нейминг по тому же принципу как выше
    public OrderPage placeAnOrder(){
        buttonOrderInOrder.click();
        buttonYesInOrder.click();
        return this;
    }

    @Step("Клик по кнопке 'Заказать' в заказе") //снвоа клик
    public OrderPage orderButtonInOrder(){
        buttonOrderInOrder.click();
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
    public OrderPage checkCorrectAddress(){
        errorAddressMessage.shouldHave(text("Введите корректный адрес"));
        return this;
    }

    @Step("Проверка оформленного заказа")
    public void checkCompleteOrder(){
        buttonViewStatus.click();
        completedOrderWindow.shouldHave(text("Владимир"),//сделать параметризацию (так Саня сказал) чтобы не было хардкода как параметр и прокидывать его сюда
                text("Иванов"),
                text("Москва, ул. Пушкина, 47"),
                text("+79194532558"));
    }

    @Step("Проверка неоформленного заказа")
    public OrderPage checkNotCompleteOrder(){
        confirmWindow.shouldNotHave(appear);
        return this;
    }

    @Step("Клик по логотипу 'Самокат'") //клик снова ёбаный
    public OrderPage clickScooterLogo(){
        scooterLogo.click();
        return this;
    }

    @Step("Проверка ссылки перенаправления") //тоже параметризация требуется
    public void checkLinkPage(){
        webdriver().shouldNotHave(url(yandexUrl));
        webdriver().shouldHave(url(baseUrl));
    }
}


