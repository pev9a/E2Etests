package ru.scooter.test;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ImportantQuestionsTest extends TestBase{

    @Test
    void dropdownListTextTest(){
        open(baseUrl);
        $("#rcc-confirm-button").click();

        $("#accordion__heading-0").click();
        $(".accordion__panel").shouldHave(text("Сутки — 400 рублей. Оплата курьеру — наличными или картой."));

        $("#accordion__heading-1").click();
        $("#accordion__panel-1").shouldHave(text("Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."));

        $("#accordion__heading-2").click();
        $("#accordion__panel-2").shouldHave(text("Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."));

        $("#accordion__heading-3").click();
        $("#accordion__panel-3").shouldHave(text("Только начиная с завтрашнего дня. Но скоро станем расторопнее."));

        $("#accordion__heading-4").click();
        $("#accordion__panel-4").shouldHave(text("Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."));

        $("#accordion__heading-5").click();
        $("#accordion__panel-5").shouldHave(text("Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."));

        $("#accordion__heading-6").click();
        $("#accordion__panel-6").shouldHave(text("Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."));

        $("#accordion__heading-7").click();
        $("#accordion__panel-7").shouldHave(text("Да, обязательно. Всем самокатов! И Москве, и Московской области."));


    }
}
