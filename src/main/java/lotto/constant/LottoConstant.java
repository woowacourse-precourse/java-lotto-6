package lotto.constant;

public enum LottoConstant {
    LOTTO_PRICE(1000),
    START_LOTTO_NUMBER(1),
    END_LOTTO_NUMBER(45),

    LOTTO_NUMBER_COUNT(6);
    private int value;

    LottoConstant(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }
}
