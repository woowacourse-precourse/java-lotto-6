package lotto.model;

public enum LottoConstant {

    LOTTO_NUMBERS_SIZE(6);

    private final int value;

    LottoConstant(final int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
