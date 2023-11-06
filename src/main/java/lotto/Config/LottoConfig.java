package lotto.Config;

public enum LottoConfig {
    PRICE(1000),
    MIN_NUMBER(1),
    MAX_NUMBER(45);

    private final int value;

    LottoConfig(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
