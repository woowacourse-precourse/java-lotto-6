package lotto.constant;

public enum Format {
    REGEX_DIGIT("^[\\d]*$"),
    DELIMITER(","),
    DOUBLEFORMAT("%.1f");
    private final String value;

    Format(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
