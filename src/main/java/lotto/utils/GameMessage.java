package lotto.utils;

public enum GameMessage {
    REQUEST_AMOUNT("구입금액을 입력해 주세요."),
    REQUEST_WIN_NUMBERS("당첨 번호를 입력해 주세요."),
    REQUEST_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    WINNING_STATISTICS("당첨 통계\n" + "---"),
    PURCHASED("개를 구매했습니다."),
    COUNT("개"),
    RATE_OF_RETURN("총 수익률은 "),
    IS("%입니다."),
    THREE_PRIZE("(5,000원) - "),
    FOUR_PRIZE("(50,000원) - "),
    FIVE_PRIZE("(1,500,000원) - "),
    SIX_PRIZE("(2,000,000,000원) - "),
    BONUS_PRIZE("(30,000,000원) - "),
    DELIMITER(","),
    OPENING_SQUARE_BRACKET("["),
    CLOSE_SQUARE_BRACKET("]"),
    THREE_MATCH("3개 일치"),
    FOUR_MATCH("4개 일치"),
    FIVE_MATCH("5개 일치"),
    SIX_MATCH("6개 일치"),
    BONUS_MATCH("5개 일치, 보너스 볼 일치");

    private final String message;

    GameMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
