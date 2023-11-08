package lotto.Utils;

public enum LottoConstantNumbers {
    LOTTO_NUMBER_COUNT(6),
    MIN_LOTTO_NUMBER(1),
    MAX_LOTTO_NUMBER(45),
    FIFTH_RANK(5000),
    FOURTH_RANK(50000),
    THIRD_RANK(1500000),
    SECOND_RANK( 30000000),
    FIRST_RANK(2000000000);

    private final int value;

    private LottoConstantNumbers(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
