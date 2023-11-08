package lotto.utils;

public enum LottoConstants {
    A_LOTTO_PRICE(1000),
    CORRECT_LOTTO_WINNING_NUMBERS_SIZE(6),
    LOTTO_WINNING_RANK_MAP_INIT_VALUE(0);

    private final int value;

    LottoConstants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

