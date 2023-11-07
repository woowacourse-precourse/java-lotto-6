package message;

public enum Symbol {
    OPEN_SQUARE_BRACKET("["),
    CLOSE_SQUARE_BRACKET("]"),
    COMMA(","),
    NEXT_LINE("\n"),
    SPACE(" "),
    OPEN_BRACKET("("),
    CLOSE_BRACKET(")"),
    DECIMAL_PATTERN("###,###"),
    WON("원"),
    DASH("-"),
    COUNT("개");

    String symbol;
    Symbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
