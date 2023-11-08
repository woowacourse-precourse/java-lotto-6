package lotto.constant;

public enum Config {
    LOTTO_PRICE(1000),
    NUMBER_OF_LOTTO_NUMBERS(6);

    private final int config;

    Config(int config) {
        this.config = config;
    }

    public int getConfig() {
        return config;
    }

}
