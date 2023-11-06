package lotto.condition;

public enum Symbols {
    DELIMITER(","),
    SEPARATOR("--");

    private final String symbol;

    Symbols(final String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
