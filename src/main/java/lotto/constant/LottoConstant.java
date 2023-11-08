package lotto.constant;

public enum LottoConstant {

    MIN_VALUE(1),
    MAX_VALUE(45),
    UNIQUE_NUMBERS(6),
    LOTTO_PRICE(1000);

    private final int value;

    LottoConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
