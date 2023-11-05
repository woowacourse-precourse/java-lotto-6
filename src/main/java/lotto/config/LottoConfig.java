package lotto.config;

public enum LottoConfig {
    SIZE(6),
    RANGE_START(1),
    RANGE_END(45),
    PRICE(1000);

    private final int value;

    LottoConfig(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }
}
