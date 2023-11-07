package lotto.constant.constants;

public enum Config {
    LOTTO_PRICE(1000),
    LOTTO_MIN_NUMBER(1),
    LOTTO_MAX_NUMBER(45),
    LOTTO_SIZE(6);

    private final Integer config;

    Config(Integer config) {
        this.config = config;
    }

    public Integer getConfig() {
        return this.config;
    }

}
