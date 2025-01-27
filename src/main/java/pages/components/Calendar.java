package pages.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;

public class Calendar {
    private final SelenideElement
            dateDeliveryLocator = $(".react-datepicker__input-container input");

    @Step("Установка даты")
    public void setDate(String value) {
        dateDeliveryLocator.click();
        dateDeliveryLocator.setValue(value);
        dateDeliveryLocator.sendKeys(Keys.ENTER);
    }

    @Step("Очистка поля ввода даты")
    public void removeDate(){
        dateDeliveryLocator.doubleClick();
        dateDeliveryLocator.clear();
    }
}
