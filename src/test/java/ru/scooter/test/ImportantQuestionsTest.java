package ru.scooter.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pageObjects.MainPage;
import ru.scooter.helpers.TestBase;

public class ImportantQuestionsTest extends TestBase {
    MainPage mainPage = new MainPage();

    @Test
    @DisplayName("Проверка вопросов 'Вопросы о важном'")
    void dropdownListTextTest(){
        mainPage.checkAnswerTheQuestionOne()
                .checkAnswerTheQuestionTwo()
                .checkAnswerTheQuestionThree()
                .checkAnswerTheQuestionFour()
                .checkAnswerTheQuestionFive()
                .checkAnswerTheQuestionSix()
                .checkAnswerTheQuestionSeven()
                .checkAnswerTheQuestionEight();
    }
}
