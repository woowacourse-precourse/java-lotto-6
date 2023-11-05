package lotto.Constants;

public enum IntConstants {
    MIN_RANGE(1),
    MAX_RANGE(45),
    UNIT_BILL(1000),
    LOTTO_NUMBER_COUNT(6),
    THREE_HIT(3),
    FOUR_HIT(4),
    FIVE_HIT(5),
    SIX_HIT(6),
    FIRST_INDEX(0),
    SECOND_INDEX(1),
    THIRD_INDEX(2),
    FORTH_INDEX(3),
    FIFTH_INDEX(4);


    int value;

    IntConstants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
