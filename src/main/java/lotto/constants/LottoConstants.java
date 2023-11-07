package lotto.constants;

public enum LottoConstants {
    RANDOM_MIN_NUMBER(1),
    RANDOM_MAX_NUMBER(45),
    COUNT(6),
    PRIZE_COUNT_INCREMENT(1),
    NUMBER_SEPARATOR(", "),
    START_SYMBOL("["),
    END_SYMBOL("]"),
    ZERO(0),
    THOUSAND(1000),
    PERCENT(100);

    private int number;
    private String message;

    LottoConstants(int number) {
        this.number = number;
    }

    LottoConstants(String message) {
        this.message = message;
    }

    public int getNumber() {
        return number;
    }

    public String getMessage() {
        return message;
    }
}
