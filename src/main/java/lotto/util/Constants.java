package lotto.util;

public enum Constants {

    COMMA(",");

    private final String value;

    Constants(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
