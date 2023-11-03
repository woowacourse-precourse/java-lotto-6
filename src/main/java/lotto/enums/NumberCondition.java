package lotto.enums;

public enum NumberCondition {
    LOTTO_SIZE(6),
    LOTTO_MAX(45),
    LOTTO_MIN(1),
    MONEY_UNIT(1000),
    LOWEST_PRIZE_RANK(5);

    private final int number;

    NumberCondition(int number) {
        this.number = number;
    }

    public int number() {
        return number;
    }
}
