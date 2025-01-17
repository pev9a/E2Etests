package ru.scooter.test;

import org.junit.jupiter.api.Test;
import pageObjects.MainPage;
import ru.scooter.helpers.TestBase;

public class ImportantQuestionsTest extends TestBase {
    MainPage mainPage = new MainPage();

    //аннотации
    @Test
    void dropdownListTextTest(){
        mainPage.openPage()
                .checkAnswerTheFirstQuestion()
                .checkAnsTheQue2()
                .checkAnsTheQue3()
                .checkAnsTheQue4()
                .checkAnsTheQue5()
                .checkAnsTheQue6()
                .checkAnsTheQue7()
                .checkAnsTheQue8();

    }
}
