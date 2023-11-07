package lotto.v3.model;

public enum LottoConstants {
    LOTTO_PRICE(1000),
    MAX_RETRY_ATTEMPTS(10);

    private final int value;

    LottoConstants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
