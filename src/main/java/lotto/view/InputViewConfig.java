package lotto.view;

public enum InputViewConfig {

    NUMBERS_DELIMITER("숫자들 구분자", ",");

    private final String description;
    private final String value;

    InputViewConfig(String description, String value) {
        this.description = description;
        this.value = value;
    }

    String getValue() {
        return value;
    }

}
