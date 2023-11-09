package lotto.utils;

public enum LottoConstants {

    LOTTO_NUMBER_SIZE(6),
    LOTTO_MINIMUM_VALUE(1),
    LOTTO_MAXIMUM_VALUE(45),
    LOTTO_PRICE(1000),
    DIVIDE_UP_VALUE(0),
    ISSUE_START_VALUE(0),
    RANK_INIT_VALUE(0),
    RANK_PLUS_VALUE(1),
    RATE_OF_RETURN_MULTIPLY_VALUE(100);

    private final int value;

    LottoConstants(int value) {
        this.value = value;
    }

    public int getConstants() {
        return value;
    }
}
