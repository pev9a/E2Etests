package ru.scooter.helpers;

public class TestData extends TestBase{ //схуя в хелперах, должен быть отдельный ПЭКЕДЖ названный тест дата и можно это тоже енамчиком сделать
    //также неясно зачем он наследуется от тестбейза если не используется от него нихуя
    protected final String name = "Владимир";
    protected final String lastname = "Иванов";
    protected final String address = "Москва, ул. Пушкина, 47";
    protected final String incorrectAddress = "2";
    protected final String metro = "Фрунзенская";
    protected final String phone = "+79194532558";
    protected final String date = "06.01.2025";
    protected final String rent = "трое суток";
    protected final String color = "чёрный жемчуг";
    protected final String comment = "Позвонить перед доставкой";
}
