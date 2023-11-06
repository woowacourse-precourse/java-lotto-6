package lotto.utils;

public enum GameNumber {
    ZERO(0),
    THOUSAND(1000),
    ONE(1),
    MIN_RANGE(1),
    MAX_RANGE(45),
    LOTTO_SIZE(6),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    THREE_PRIZE(5000),
    FOUR_PRIZE(50000),
    FIVE_PRIZE(1500000),
    SIX_PRIZE(2000000000),
    BONUS_PRIZE(30000000);

    private final int number;

    GameNumber(int number) {
        this.number = number;
    }
    
    public int getNumber() {
        return this.number;
    }
}
