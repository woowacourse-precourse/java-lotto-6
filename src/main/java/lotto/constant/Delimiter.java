package lotto.constant;

public enum Delimiter {
    SEQUENCE(",");

    private final String value;

    Delimiter(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
