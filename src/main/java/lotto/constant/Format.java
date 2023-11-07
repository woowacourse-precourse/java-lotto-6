package lotto.constant;

public enum Format {
    DELIMITER(","),
    EMPTY_REGEX(""),
    STATISTICS_JOIN_HYPHEN(" - "),
    NEW_LINE("\n"),
    WIN_COUNT_UNIT("개");

    private final String format;

    Format(String format) {
        this.format = format;
    }

    public String get() {
        return format;
    }
}