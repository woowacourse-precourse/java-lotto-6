package lotto.message;

public enum Message {
    PAYMENT_REQUEST("구입금액을 입력해 주세요."),
    PAYMENT_COMPLETE("개를 구매했습니다."),
    WINNING_NUMBER_REQUEST("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_REQUEST("보너스 번호를 입력해 주세요."),
    WINNING_STATISTICS_RESULT("당첨 통계"),
    DIVIDING_LINE("-"),
    MATCH("일치"),
    LEFT_PARENTHESIS("("),
    RIGHT_PARENTHESIS(")"),
    WON("원"),
    COUNT("개"),
    COMMA(","),
    SPACE(" "),
    TOTAL_RETURN("총 수익률은"),
    PERCENT_SIGN("%"),
    END_EXPLAINE("입니다."),
    LINE_BREAK("\n");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
