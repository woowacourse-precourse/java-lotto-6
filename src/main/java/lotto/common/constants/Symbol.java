package lotto.common.constants;

public enum Symbol {
    COMMA(","),
    DIVIDE_LINE("---"),
    ONLY_NUMBER("^[0-9]*$");

    private final String symbol;

    Symbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
