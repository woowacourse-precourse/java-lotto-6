package message;

public enum Symbol {
    OPEN_SQUARE_BRACKET("["),
    CLOSE_SQUARE_BRACKET("]"),
    COMMA(","),
    NEXT_LINE("\n");

    String symbol;
    Symbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
