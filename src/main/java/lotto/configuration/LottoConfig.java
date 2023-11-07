package lotto.configuration;

public enum LottoConfig {
    START(1),
    END(45),
    COUNT(6);

    private final int value;

    LottoConfig(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
