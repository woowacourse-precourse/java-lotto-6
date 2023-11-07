package lotto.constant;

public enum Number {
    LOTTO_LENGTH_LIMIT(6),
    THE_SMALLEST_LOTTO_NUMBER(1),
    THE_BIGGEST_LOTTO_NUMBER(45),

    THOUSAND(1000);

    private final int message;

    Number(int message) {
        this.message = message;
    }

    public final int getMessage() {
        return message;
    }
}
