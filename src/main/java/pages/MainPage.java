package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static pages.components.AnswerTheQuestion.*;

public class MainPage {

    private final SelenideElement
            confirmCookiesButton = $("#rcc-confirm-button"),
            QuestionOne = $("#accordion__heading-0"),
            AnswerOne = $(".accordion__panel"),
            QuestionTwo = $("#accordion__heading-1"),
            AnswerTwo = $("#accordion__panel-1"),
            QuestionThree = $("#accordion__heading-2"),
            AnswerThree = $("#accordion__panel-2"),
            QuestionFour = $("#accordion__heading-3"),
            AnswerFour = $("#accordion__panel-3"),
            QuestionFive = $("#accordion__heading-4"),
            AnswerFive = $("#accordion__panel-4"),
            QuestionSix = $("#accordion__heading-5"),
            AnswerSix = $("#accordion__panel-5"),
            QuestionSeven = $("#accordion__heading-6"),
            AnswerSeven = $("#accordion__panel-6"),
            QuestionEight = $("#accordion__heading-7"),
            AnswerEight = $("#accordion__panel-7");
    //сделать нейминг относительно содержания страницы по типу "Сколько будет стоить" = HowMuchCostQuestion

    @Step("Принятие cookies") // норм пример того как должен быть выстроен нейминг, вместо кликов
    public void acceptCookies(){
        confirmCookiesButton.shouldBe(visible).click();
    }// создать общий класс Common и вынести туда этот метод

    @Step("Проверка текста ответа на первый вопрос") // нейминг относительно содержания вопроса
    public MainPage checkAnswerTheQuestionOne(){
        QuestionOne.click();
        AnswerOne.shouldHave(text(FIRST_RESPONSE_TEXT.getText()));
        return this;
    }

    @Step("Проверка текста второй на первый вопрос")
    public MainPage checkAnswerTheQuestionTwo(){
        QuestionTwo.click();
        AnswerTwo.shouldHave(text(TEXT_OF_THE_SECOND_ANSWER.getText()));
        return this;
    }

    @Step("Проверка текста ответа на третий вопрос")
    public MainPage checkAnswerTheQuestionThree(){
        QuestionThree.click();
        AnswerThree.shouldHave(text(TEXT_OF_THE_THIRD_ANSWER.getText()));
        return this;
    }

    @Step("Проверка текста ответа на четвертый вопрос")
    public MainPage checkAnswerTheQuestionFour(){
        QuestionFour.click();
        AnswerFour.shouldHave(text(TEXT_OF_THE_FOURTH_ANSWER.getText()));
        return this;
    }

    @Step("Проверка текста ответа на пятый вопрос")
    public MainPage checkAnswerTheQuestionFive(){
        QuestionFive.click();
        AnswerFive.shouldHave(text(TEXT_OF_THE_FIFTH_ANSWER.getText()));
        return this;
    }

    @Step("Проверка текста ответа на шестой вопрос")
    public MainPage checkAnswerTheQuestionSix(){
        QuestionSix.click();
        AnswerSix.shouldHave(text(TEXT_OF_THE_SIXTH_ANSWER.getText()));
        return this;
    }

    @Step("Проверка текста ответа на седьмой вопрос")
    public MainPage checkAnswerTheQuestionSeven(){
        QuestionSeven.click();
        AnswerSeven.shouldHave(text(TEXT_OF_THE_SEVENTH_ANSWER.getText()));
        return this;
    }

    @Step("Проверка текста ответа на восьмой вопрос")
    public void checkAnswerTheQuestionEight(){
        QuestionEight.click();
        AnswerEight.shouldHave(text(TEXT_OF_THE_EIGHT_ANSWER.getText()));
        //добавить return;
    }
}
