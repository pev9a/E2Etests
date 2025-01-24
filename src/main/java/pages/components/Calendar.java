package pages.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;

public class Calendar {
    private final SelenideElement
            dateDelivery = $(".react-datepicker__input-container"),
            deliveryDateInput = $(".Input_Input__1iN_Z.Input_Responsible__1jDKN.react-datepicker-ignore-onclickoutside"); //Сане не нравится локатор, сделать XPATH

    @Step("Установка даты")
    public void setDate(String value) {
        dateDelivery.click();
        deliveryDateInput.setValue(value);
        deliveryDateInput.sendKeys(Keys.ENTER);
    }

    @Step("Очистка поля ввода даты")
    public void removeDate(){
        dateDelivery.click();
        for (int i = 0; i < 10; i++)
        {deliveryDateInput.sendKeys(Keys.BACK_SPACE);}
        deliveryDateInput.sendKeys(Keys.ENTER);
    }//сделать не циклом (подумать как, потому что здесь он не необходим) и почекать как ставятся скобки в цикле {}
}
