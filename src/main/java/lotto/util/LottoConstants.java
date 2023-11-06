package lotto.util;

public enum LottoConstants {
    MIN_NUMBER_RANGE(1),
    MAX_NUMBER_RANGE(45),
    NUMBER_COUNT(6);

    private int value;

    LottoConstants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static boolean isNumberInRange(int number) {
        return number >= MIN_NUMBER_RANGE.value && number <= MAX_NUMBER_RANGE.value;
    }
}
