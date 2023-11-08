package lotto.config;

public enum LottoConfig {
    START_OF_LOTTO_NUMBER(1),
    END_OF_LOTTO_NUMBER(45),
    LOTTO_NUMBER_COUNT(6),
    LOTTO_PRICE(1000);

    private final int value;

    LottoConfig(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}

