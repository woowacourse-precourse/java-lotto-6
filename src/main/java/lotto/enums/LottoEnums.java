package lotto.enums;

public enum LottoEnums {
    MIN_LOTTO_NUMBER(1),
    MAX_LOTTO_NUMBER(45),
    SELECTED_NUMBERS_SIZE(6),
    BONUS_NUMBERS_SIZE(1);

    private final int value;

    LottoEnums(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
