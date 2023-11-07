package lotto.enums;

public enum LottoConfig {
    LOTTO_MINIMUM_NUMBER(1),
    LOTTO_MAXIMUM_NUMBER(45),
    LOTTO_NUMBER_SIZE(6),
    LOTTO_AMOUNT(1000);

    private int value;

    LottoConfig(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
