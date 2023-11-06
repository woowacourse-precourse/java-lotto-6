package lotto.utils;

public enum CharUnit {
    COMMAS(',');

    private char value;

    CharUnit(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }
}
