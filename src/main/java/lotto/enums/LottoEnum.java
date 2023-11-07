package lotto.enums;

public enum LottoEnum {
    MIN_LOTTO_NUMBER(1),
    MAX_LOTTO_NUMBER(45),
    SELECTED_NUMBERS_SIZE(6),
    PURCHASE_RULE(1000);

    private final int value;

    LottoEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
