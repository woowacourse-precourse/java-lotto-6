package lotto.condition;

public enum Symbols {
    DELIMITER(","),
    SEPARATOR("---"),
    PREFIX("["),
    SUFFIX("]");

    private final String symbol;

    Symbols(final String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
