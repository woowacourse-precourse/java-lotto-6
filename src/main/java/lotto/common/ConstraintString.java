package lotto.common;

public enum ConstraintString {
    SPLIT_REGEX(","),
    ;

    private final String value;

    ConstraintString(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
