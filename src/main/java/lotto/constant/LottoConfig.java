package lotto.constant;

public enum LottoConfig {
    PURCHASE_PRICE(1000),
    MIN_LOTTO_NUMBER(1),
    MAX_LOTTO_NUMBER(45),
    TOTAL_CHOICE_NUMBER(6);

    private final int value;

    LottoConfig(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}