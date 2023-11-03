package lotto.domain.config;

public enum PropertyConfig {
    PRICE_PER_LOTTO(1000);

    private final int value;

    PropertyConfig(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
