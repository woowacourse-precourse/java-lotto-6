package lotto;

public enum IntConstants {
    MIN_RANGE(1),
    MAX_RANGE(45),
    UNIT_BILL(1000),
    LOTTO_NUMBER_COUNT(6),
    BONUS_NUMBER_COUNT(1);


    int value;

    IntConstants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
