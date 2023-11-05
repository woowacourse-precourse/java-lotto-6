package lotto.constant;

public enum LottoNumber {
    MINIMUM(1),
    MAXIMUM(45),
    PRICE(1000),
    SIZE(6);

    private final int value;

    LottoNumber(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
};