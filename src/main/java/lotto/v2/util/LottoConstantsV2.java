package lotto.v2.util;

public enum LottoConstantsV2 {
    LOTTO_NUMBER_MIN(1),
    LOTTO_NUMBER_MAX(45),
    LOTTO_NUMBERS_SIZE(6),
    LOTTO_PRICE(1000);

    private final int value;

    LottoConstantsV2(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

