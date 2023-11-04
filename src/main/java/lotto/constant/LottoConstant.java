package lotto.constant;

public enum LottoConstant {

    START_NUMBER(1),
    END_NUMBER(45),
    COUNT(6),
    LOTTO_PRICE_UNIT(1000);

    private final int value;

    LottoConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
