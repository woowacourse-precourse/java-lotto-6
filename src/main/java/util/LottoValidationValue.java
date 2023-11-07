package util;

public enum LottoValidationValue {
    LOTTO_PRICE(1000),
    LOTTO_NUMBER_MINIMUM(1),
    LOTTO_NUMBER_MAXIMUM(45),
    LOTTO_NUMBER_COUNT(6);

    private final int value;

    LottoValidationValue(int value) {
        this.value = value;
    }

    public int get() {
        return value;
    }
}
