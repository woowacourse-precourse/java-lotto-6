package lotto.config;

public enum SystemNumberConfig {
    START_NUM(0),
    LINE_REPEAT(3);

    private final int config;

    SystemNumberConfig(int config) {
        this.config = config;
    }

    public int getConfig() {
        return config;
    }
}
