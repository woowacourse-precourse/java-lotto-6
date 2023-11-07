package lotto.view.constant;

public enum CharacterSymbol {

    BLANK(" "),
    COMMA(",");

    private final String literal;

    CharacterSymbol(String symbolLiteral) {
        this.literal = symbolLiteral;
    }

    public String getLiteral() {
        return literal;
    }

}
