package lotto.domain.config;

public enum LottoConfig {
    MINIMUM_NUMBER(1),
    MAXIMUM_NUMBER(45),
    SIZE(6);

    private final int value;

    LottoConfig(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
