package lotto.domain.lotto;

public enum LottoCondition {

    NUMBER_LENGTH(6),
    MIN_NUMBER(1),
    MAX_NUMBER(45);

    private final int value;

    LottoCondition(final int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

    public static boolean isNotInRange(final int singleNumber) {
        return MIN_NUMBER.value > singleNumber || MAX_NUMBER.value < singleNumber;
    }

    public static boolean isInvalidLength(final int size) {
        return NUMBER_LENGTH.value != size;
    }
}
