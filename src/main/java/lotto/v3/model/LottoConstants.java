package lotto.v3.model;

public enum LottoConstants {
    LOTTO_PRICE(1000);

    private final int value;

    LottoConstants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
