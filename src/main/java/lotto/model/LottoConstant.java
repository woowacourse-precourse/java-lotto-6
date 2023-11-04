package lotto.model;

public enum LottoConstant {

    LOTTO_NUMBERS_SIZE(6),
    FIRST_PRIZE_MATCH(6),
    SECOND_PRIZE_MATCH(5),
    THIRD_PRIZE_MATCH(5),
    FOURTH_PRIZE_MATCH(4),
    FIFTH_PRIZE_MATCH(3),
    BONUS_MATCH_POINT(50),
    GOAL_MATCH_POINT(100);

    private final int value;

    LottoConstant(final int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
