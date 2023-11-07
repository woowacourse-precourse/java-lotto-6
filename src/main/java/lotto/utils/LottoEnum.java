package lotto.utils;

public enum LottoEnum {
    LOTTO_PRICE(1000),
    LOTTO_COUNT(6),
    LOTTO_START_NUMBER(1),
    LOTTO_END_NUMBER(45),
    LOTTO_BONUS_NUMBER_COUNT(7),
    LOTTO_BONUS_USING_CONDITION(5);

    private final int value;

    LottoEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
