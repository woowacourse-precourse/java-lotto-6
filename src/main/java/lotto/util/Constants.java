package lotto.util;

public enum Constants {

    COMMA(","),
    LIST_PREFIX("["),
    LIST_SUFFIX("]");

    private final String value;

    Constants(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
