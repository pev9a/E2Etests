package pages.testData;

public enum TestData { //схуя в хелперах, должен быть отдельный ПЭКЕДЖ названный тест дата и можно это тоже енамчиком сделать
    //также неясно зачем он наследуется от тестбейза если не используется от него нихуя
    FIRST_NAME ("Владимир"),
    LAST_NAME ("Иванов"),
    ADDRESS ("Москва, ул. Пушкина, 47"),
    INCORRECT_ADDRESS ("2"),
    SUBWAY_STATION ("Фрунзенская"),
    PHONE_NUMBER ("+79194532558"),
    DATE ("06.01.2025"),
    RENTAL_PERIOD ("трое суток"),
    SCOOTER_COLOR ("чёрный жемчуг"),
    COMMENT ("Позвонить перед доставкой");

    private final String text;

    TestData(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
