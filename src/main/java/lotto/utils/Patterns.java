package lotto.utils;

public enum Patterns {
    BUY_PRICE_PATTERN("^[0-9]*$"),
    LOTTO_NUMBER_PATTERN("^[0-9]*$"),
    WINNING_NUMBER_STRING_PATTERN("^[가-힣a-zA-Z0-9!@#$%^&*()_+]+(,[가-힣a-zA-Z0-9!@#$%^&*()_+]+){5}$");

    private final String value;

    Patterns(String value) {
        this.value = value;
    }

    public String getPattern() {
        return value;
    }
}
