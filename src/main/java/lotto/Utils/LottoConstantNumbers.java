package lotto.Utils;

public enum LottoConstantNumbers {
    LOTTO_NUMBER_COUNT(6),
    MIN_LOTTO_NUMBER(1),
    MAX_LOTTO_NUMBER(45);

    private final int value;

    private LottoConstantNumbers(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
