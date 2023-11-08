package lotto.domain.config;

public enum OrderConfig {
    PRICE_PER_LOTTO(1000);

    private final int value;

    OrderConfig(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
