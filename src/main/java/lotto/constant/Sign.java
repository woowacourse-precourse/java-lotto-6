package lotto.constant;

public enum Sign {
    DIVIDER("---"),
    SEPARATOR(" - "),
    LINE_BREAKER("\n"),
    COMMA(","),
    PERCENT("%");

    private final String sign;

    Sign(String sign) {
        this.sign = sign;
    }

    public String getSign() {
        return sign;
    }
}
