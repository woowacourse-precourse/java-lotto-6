package lotto.view;

public enum LottoWriteMessage {

    WINNING_NUMBER_MATCH_FORMAT("%d개 일치"),
    BUY_HISTORY("%d개를 구매했습니다."),
    BONUS_NUMBER_MATCH_FORMAT(", 보너스 볼 일치"),
    RESULT_FORMAT(" (%s원) - %d개"),
    TOTAL_PROFIT_FORMAT("총 수익률은 %.1f%%입니다."),
    LINE_BREAK("\n"),
    BLANK("");

    private final String message;

    LottoWriteMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
