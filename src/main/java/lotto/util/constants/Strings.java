package lotto.util.constants;

public enum Strings {
    BLANK(" "),
    NULL_STRING(""),
    COMMA(","),
    NEXT_LINE("\n"),
    LOTTO_BONUS_PAIR_STRING_FORMAT("당첨 번호 : %s\n보너스 번호 : %d");
    private final String string;

    Strings(String string) {
        this.string = string;
    }

    public String getFormat(Object... args) {
        return String.format(string, args);
    }

    public String getString() {
        return string;
    }
}
