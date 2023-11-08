package lotto.common.constants;

public enum Symbol {
    COMMA(","),
    DIVIDE_LINE("---");

    private final String symbol;

    Symbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
