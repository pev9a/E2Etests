package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class Common {
    private final SelenideElement
            confirmCookiesButton = $("#rcc-confirm-button");

    @Step("Принятие cookies")
    public void acceptCookies(){
        confirmCookiesButton.shouldBe(visible).click();
    }
}
