package lotto.domain;

public enum Symbols {
    DELIMITER(",");

    private final String symbol;

    Symbols(final String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
