package lotto.view.constants;

public enum SymbolType {
    SEPARATOR(", "),
    PREFIX("["),
    POSTFIX("]");

    private final String symbol;

    SymbolType(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return this.symbol;
    }
}
