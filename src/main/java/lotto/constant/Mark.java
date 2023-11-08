package lotto.constant;

public enum Mark {
    DELIMITER(","),
    EMPTY_REGEX(""),
    SPACE(" "),
    STATISTICS_JOIN_HYPHEN(" - "),
    NEW_LINE("\n"),
    OPEN_BRACKET("("),
    CLOSE_BRACKET(")"),
    WIN_COUNT_UNIT("개"),
    MONEY_UNIT("원"),
    PERCENT("%"),
    MONEY_PATTERN("###,###");

    private final String format;

    Mark(String format) {
        this.format = format;
    }

    public String get() {
        return format;
    }
}