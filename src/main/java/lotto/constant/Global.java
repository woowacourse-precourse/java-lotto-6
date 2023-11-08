package lotto.constant;

public enum Global {
    DELIMITER(","),
    DIGIT_REGEX("^[0-9]+$");

    private final String value;

    Global(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
