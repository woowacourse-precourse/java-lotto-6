package lotto.utils;

public enum LabelConstants {
    COMMAS(","),
    BLANK(""),
    UNIT("개")
    ;

    private final String value;

    LabelConstants(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
