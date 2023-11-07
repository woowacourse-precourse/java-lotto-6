package lotto;

public enum LottoConstants {

    NUMBER_MIN(1),
    NUMBER_MAX(45),
    PRICE(1000),
    SIZE(6),
    WINNING_FIVE_NUMBER(5),
    WINNING_FIVE_NUMBER_WITH_BONUS_NUMBER(5),
    PRIZE_MATCH_COUNT_3(5000),
    PRIZE_MATCH_COUNT_4(50000),
    PRIZE_MATCH_COUNT_5(1500000),
    PRIZE_MATCH_COUNT_5_BONUS(30000000),
    PRIZE_MATCH_COUNT_6(2000000000);



    private final int value;

    LottoConstants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}