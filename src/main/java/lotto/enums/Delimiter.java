package lotto.enums;

public enum Delimiter {
    COMMA(","),
    ERROR_PREFIX("[ERROR] ");

    private final String delimiter;

    Delimiter(String delimiter) {
        this.delimiter = delimiter;
    }

    public String getDelimiter() {
        return delimiter;
    }
}
