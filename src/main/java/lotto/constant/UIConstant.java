package lotto.constant;

public enum UIConstant {
    ERROR_TAG("[ERROR]"),
    LOTTO_NUMBER_OPENING_BRACKET("["),
    LOTTO_NUMBER_CLOSING_BRACKET("]"),
    WINNING_STATISTICS_OPENING("---"),
    NUMBER_SEPARATOR(","),
    NEW_LINE("\n"),

    SENTENCE_ENDING("입니다.");
    
    private final String ui;

    UIConstant(String ui) {
        this.ui = ui;
    }

    @Override
    public String toString() {
        return this.ui;
    }
}
