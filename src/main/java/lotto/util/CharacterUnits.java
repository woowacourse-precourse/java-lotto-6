package lotto.util;

public enum CharacterUnits {
    COMMA(","),
    SPACE(" "),
    LEFT_BRACKET("["),
    RIGHT_BRACKET("]"),
    PATTERN("[ !@#$%^&*().?\":{}|<>]"),
    SEPARATOR(",");


    private final String unit;

    CharacterUnits(String unit) {
        this.unit = unit;
    }

    public String getUnit() {
        return unit;
    }
}
