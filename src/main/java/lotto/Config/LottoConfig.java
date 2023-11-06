package lotto.Config;

public enum LottoConfig {
    PRICE(1000),
    MIN_NUMBER(1),
    MAX_NUMBER(45),
    FIRST_PRIZE(6, 2_000_000_000),
    SECOND_PRIZE(5, 30_000_000),
    THIRD_PRIZE(5, 1_500_000),
    FOURTH_PRIZE(4, 50_000),
    FIFTH_PRIZE(3, 5_000);

    private final int matchingNumbers;
    private final int prizeMoney;

    LottoConfig(int value) {
        this.matchingNumbers = value;
        this.prizeMoney = 0;
    }

    LottoConfig(int matchingNumbers, int prizeMoney) {
        this.matchingNumbers = matchingNumbers;
        this.prizeMoney = prizeMoney;
    }

    public int getValue() {
        return matchingNumbers;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

}
