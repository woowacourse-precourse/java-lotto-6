package lotto.domain.config;

public enum LottoConfig {
    LOTTO_MINIMUM_NUMBER(1),
    LOTTO_MAXIMUM_NUMBER(45),
    LOTTO_SIZE(6);

    private final int value;

    LottoConfig(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
