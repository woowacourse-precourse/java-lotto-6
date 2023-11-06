package lotto.utils;

public enum StringUnit {
    COMMAS(","),
    BLANK(""),
    UNIT("개")
    ;

    private final String value;

    StringUnit(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
