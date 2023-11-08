package lotto.constants;

public enum LottoValidationPattern {
    DELIMITER(","),
    WINNING_NUMBER_INPUT_FORMAT("^\\d+(,\\d+){5}$");

    private final String pattern;

    LottoValidationPattern(String pattern) {
        this.pattern = pattern;
    }

    public String pattern() {
        return pattern;
    }
}
