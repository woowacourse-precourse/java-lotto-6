package lotto.util.constants;

public enum Strings {
    BLANK(" "),
    NULL_STRING(""),
    COMMA(","),
    NEXT_LINE("\n");
    private final String string;
    Strings(String string) {
        this.string = string;
    }

    public String getString() {
        return string;
    }
}
