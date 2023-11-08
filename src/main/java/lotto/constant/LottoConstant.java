package lotto.constant;

public enum LottoConstant {
    LOTTO_MIN_NUM(1),
    LOTTO_MAX_NUM(45),
    LOTTO_ITEM_COUNT(6),
    LOTTO_PRICE(1000);

    private final int value;

    LottoConstant(final int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}