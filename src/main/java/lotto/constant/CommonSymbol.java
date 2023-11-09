package lotto.constant;

public enum CommonSymbol {

    COMMA(",");

    private final String symbol;

    CommonSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
