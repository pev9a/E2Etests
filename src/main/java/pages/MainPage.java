package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static pages.testData.AnswerTheQuestion.*;

public class MainPage {

    private final SelenideElement
            HowMuchCostQuestion = $("#accordion__heading-0"),
            fourHundredRublesForDayAnswer = $(".accordion__panel"),
            isItPossibleToHaveSeveralScootersAtOnceQuestion = $("#accordion__heading-1"),
            oneOrderOneScooterAnswer = $("#accordion__panel-1"),
            howIsRentalTimeCalculatedQuestions = $("#accordion__heading-2"),
            theRentalTimeStartsAnswer = $("#accordion__panel-2"),
            isItPossibleToGetScooterTodayQuestions = $("#accordion__heading-3"),
            startingTomorrowAnswer = $("#accordion__panel-3"),
            isItPossibleToExtendTheOrderQuestion = $("#accordion__heading-4"),
            notYetAnswer = $("#accordion__panel-4"),
            areYouBringingChargersQuestion = $("#accordion__heading-5"),
            scooterWithFullChargeAnswer = $("#accordion__panel-5"),
            isItPossibleToCancelAnOrderQuestion = $("#accordion__heading-6"),
            scooterWasNotDeliveredAnswer = $("#accordion__panel-6"),
            bringItOutsideTheMoscowRingRoadQuestion = $("#accordion__heading-7"),
            definitelyAllScootersAnswer = $("#accordion__panel-7");
    //сделать нейминг относительно содержания страницы по типу "Сколько будет стоить" = HowMuchCostQuestion

    @Step("Проверка текста ответа 'Сутки — 400 рублей'") // нейминг относительно содержания вопроса
    public MainPage checkAnswerFourHundredRublesForDay(){
        HowMuchCostQuestion.click();
        fourHundredRublesForDayAnswer.shouldHave(text(FIRST_RESPONSE_TEXT.getText()));
        return this;
    }

    @Step("Проверка текста ответа 'Один заказ — один самокат'")
    public MainPage checkAnswerOneOrderOneScooter(){
        isItPossibleToHaveSeveralScootersAtOnceQuestion.click();
        oneOrderOneScooterAnswer.shouldHave(text(TEXT_OF_THE_SECOND_ANSWER.getText()));
        return this;
    }

    @Step("Проверка текста ответа 'Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру.'")
    public MainPage checkAnswerTheRentalTimeStarts(){
        howIsRentalTimeCalculatedQuestions.click();
        theRentalTimeStartsAnswer.shouldHave(text(TEXT_OF_THE_THIRD_ANSWER.getText()));
        return this;
    }

    @Step("Проверка текста ответа 'Только начиная с завтрашнего дня'")
    public MainPage checkAnswerStartingTomorrow(){
        isItPossibleToGetScooterTodayQuestions.click();
        startingTomorrowAnswer.shouldHave(text(TEXT_OF_THE_FOURTH_ANSWER.getText()));
        return this;
    }

    @Step("Проверка текста ответа 'Пока что нет!'")
    public MainPage checkAnswerNotYet(){
        isItPossibleToExtendTheOrderQuestion.click();
        notYetAnswer.shouldHave(text(TEXT_OF_THE_FIFTH_ANSWER.getText()));
        return this;
    }

    @Step("Проверка текста ответа 'Самокат приезжает к вам с полной зарядкой.'")
    public MainPage checkAnswerScooterWithFullCharge(){
        areYouBringingChargersQuestion.click();
        scooterWithFullChargeAnswer.shouldHave(text(TEXT_OF_THE_SIXTH_ANSWER.getText()));
        return this;
    }

    @Step("Проверка текста ответа 'Да, пока самокат не привезли.'")
    public MainPage checkAnswerScooterWasNotDelivered(){
        isItPossibleToCancelAnOrderQuestion.click();
        scooterWasNotDeliveredAnswer.shouldHave(text(TEXT_OF_THE_SEVENTH_ANSWER.getText()));
        return this;
    }

    @Step("Проверка текста ответа 'Да, обязательно. Всем самокатов!'")
    public void checkAnswerDefinitelyAllScooters(){
        bringItOutsideTheMoscowRingRoadQuestion.click();
        definitelyAllScootersAnswer.shouldHave(text(TEXT_OF_THE_EIGHT_ANSWER.getText()));
        //добавить return;
    }

    @Step("Метод проверки вопросов 'Вопросы о важном'")
    public void methodForCheckingAnswersToQuestion(){
        checkAnswerFourHundredRublesForDay()
                .checkAnswerOneOrderOneScooter()
                .checkAnswerTheRentalTimeStarts()
                .checkAnswerStartingTomorrow()
                .checkAnswerNotYet()
                .checkAnswerScooterWithFullCharge()
                .checkAnswerScooterWasNotDelivered()
                .checkAnswerDefinitelyAllScooters();
    }
}
