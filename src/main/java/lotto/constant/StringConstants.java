package lotto.constant;

public enum StringConstants {
    BLANK(" "),
    EMPTY(""),
    NUMBER_SEPARATOR(","),
    LOTTO_SEPARATOR(",");

    private final String value;

    StringConstants(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
