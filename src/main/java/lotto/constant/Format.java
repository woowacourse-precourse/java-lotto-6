package lotto.constant;

public enum Format {
    DELIMITER(","),
    EMPTY_REGEX("");

    private final String format;

    Format(String format) {
        this.format = format;
    }

    public String get() {
        return format;
    }
}