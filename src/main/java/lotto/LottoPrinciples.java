package lotto;

public enum LottoPrinciples {
    MIN_NUMBER(1),
    MAX_NUMBER(45),
    LIMIT_NUMBER(6),
    MAX_SUM_COUNT(12),
    SIXTH_MATCHES(6),
    FIFTH_MATCHES(5),
    FOURTH_MATCHES(4),
    THIRD_MATCHES(3);

    private Integer number;

    private LottoPrinciples(int number) {
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }
}
