package lotto.common.config;

public enum UserRule {
    LOTTO_COST_UNIT("000"),
    WINING_NUMBERS_SEPARATOR(",");

    private final String value;

    UserRule(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}
