package ru.scooter.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import ru.scooter.Configuration.TestBase;

public class ImportantQuestionsTest extends TestBase {
    MainPage mainPage = new MainPage();

    @Test
    @DisplayName("Проверка вопросов 'Вопросы о важном'")
    void dropdownListTextTest(){
        mainPage.methodForCheckingAnswersToQuestion();
    }
}
