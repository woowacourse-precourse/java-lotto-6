package lotto.constant;

public enum UIConstant {
    ERROR_TAG("[ERROR]"),

    OPENING_BRACKET("["),

    CLOSING_BRACKET("]"),
    NUMBER_SEPARATOR(","),
    BLANK(" "),
    NEW_LINE("\n");

    
    private final String ui;

    UIConstant(String ui) {
        this.ui = ui;
    }

    @Override
    public String toString() {
        return this.ui;
    }
}
