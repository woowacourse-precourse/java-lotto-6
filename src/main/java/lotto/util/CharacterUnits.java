package lotto.util;

public enum CharacterUnits {
    COMMA(","),
    SPACE(" "),
    LEFT_BRACKET("["),
    RIGHT_BRACKET("]"),
    SEPARATOR(","),
    ENTER("\n"),
    LINE("---");


    private final String unit;

    CharacterUnits(String unit) {
        this.unit = unit;
    }

    public String getUnit() {
        return unit;
    }
}
