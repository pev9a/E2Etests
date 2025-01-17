package pageObjects;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {
//вынести текст в enum
    private final SelenideElement
            confirmCookiesButton = $("#rcc-confirm-button"),
            Question1 = $("#accordion__heading-0"), Answer1 = $(".accordion__panel"),
            Question2 = $("#accordion__heading-1"), Answer2 = $("#accordion__panel-1"),
            Question3 = $("#accordion__heading-2"), Answer3 = $("#accordion__panel-2"),
            Question4 = $("#accordion__heading-3"), Answer4 = $("#accordion__panel-3"),
            Question5 = $("#accordion__heading-4"), Answer5 = $("#accordion__panel-4"),
            Question6 = $("#accordion__heading-5"), Answer6 = $("#accordion__panel-5"),
            Question7 = $("#accordion__heading-6"), Answer7 = $("#accordion__panel-6"),
            Question8 = $("#accordion__heading-7"), Answer8 = $("#accordion__panel-7");

    public MainPage openPage(){
        open(baseUrl);
        confirmCookiesButton.click();
        return this;
    }

    public MainPage checkAnswerTheFirstQuestion(){
        Question1.click();
        Answer1.shouldHave(text("Сутки — 400 рублей. Оплата курьеру — наличными или картой."));
        return this;
    }

    public MainPage checkAnsTheQue2(){
        Question2.click();
        Answer2.shouldHave(text("Пока что у нас так: один заказ — один самокат. " +
                "Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."));
        return this;
    }

    public MainPage checkAnsTheQue3(){
        Question3.click();
        Answer3.shouldHave(text("Допустим, вы оформляете заказ на 8 мая. " +
                "Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. " +
                "Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."));
        return this;
    }

    public MainPage checkAnsTheQue4(){
        Question4.click();
        Answer4.shouldHave(text("Только начиная с завтрашнего дня. Но скоро станем расторопнее."));
        return this;
    }

    public MainPage checkAnsTheQue5(){
        Question5.click();
        Answer5.shouldHave(text("Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."));
        return this;
    }

    public MainPage checkAnsTheQue6(){
        Question6.click();
        Answer6.shouldHave(text("Самокат приезжает к вам с полной зарядкой. " +
                "Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."));
        return this;
    }

    public MainPage checkAnsTheQue7(){
        Question7.click();
        Answer7.shouldHave(text("Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."));
        return this;
    }

    public void checkAnsTheQue8(){
        Question8.click();
        Answer8.shouldHave(text("Да, обязательно. Всем самокатов! И Москве, и Московской области."));
    }

}
