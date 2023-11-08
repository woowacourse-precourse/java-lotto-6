package consts;

public enum Mark {
    COMMA(","),
    COLON(":"),
    OPEN_BRACKET("["),
    CLOSE_BRACKET("]"),
    NEW_LINE("\n"),
    EMPTY(""),
    SPACE(" "),
    HYPHEN("-");

    private final String mark;

    Mark(String mark) {
        this.mark = mark;
    }

    public String getMark() {
        return mark;
    }
}
