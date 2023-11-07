package lotto.constants;

public enum LottoConfiguration {
    MIN_PRICE(1000),
    MAX_PRICE(100000),
    MIN_RANGE(1),
    MAX_RANGE(45),
    LOTTO_SIZE(6),
    SECOND_PRIZE_COUNT(5),
    LOTTO_SEPARATOR(",");

    private int config;
    private String separator;

    LottoConfiguration(int config) {
        this.config = config;
    }

    LottoConfiguration(String separator) {
        this.separator = separator;
    }

    public int getConfig() {
        return config;
    }

    public String getSeparator() {
        return separator;
    }
}
