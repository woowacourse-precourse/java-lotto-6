package lotto.utils;

public enum CharConstants {
    COMMAS(',');

    private final char value;

    CharConstants(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }
}
