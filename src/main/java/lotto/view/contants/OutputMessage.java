package lotto.view.contants;

public enum OutputMessage {
    BLANK(" "),
    DASH("-"),
    COMMA(","),
    OPEN_PARENTHESIS("("),
    CLOSE_PARENTHESIS(")"),

    WINNING_STATISTICS("당첨 통계\n---"),
    SAME("%s개 일치"),
    BONUS("보너스 볼 일치"),
    AMOUNT("%s원"),
    COUNT("%s개"),
    RATE_OF_RETURN("총 수익률은 %s%%입니다.");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getValue() {
        return this.message;
    }
}
