package lotto.view.constants;

public enum PrintSymbol {
    DELIMITER_WITH_SPACE(", ");

    private final String value;

    PrintSymbol(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
