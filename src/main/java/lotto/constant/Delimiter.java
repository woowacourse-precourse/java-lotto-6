package lotto.constant;

public enum Delimiter {


    COMMA(",");

    private String delimiter;

    Delimiter(String delimiter) {
        this.delimiter = delimiter;
    }

    public String getDelimiter() {
        return delimiter;
    }
}
