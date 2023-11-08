package lotto.config;

public enum SystemNumberConfig {
    START_NUM(0),
    LINE_REPEAT(3),
    SIZE(6),
    RANDOM_START(1),
    RANDOM_END(45),
    THOUSAND(1000);


    private final int config;

    SystemNumberConfig(int config) {
        this.config = config;
    }

    public int getConfig() {
        return config;
    }
}
