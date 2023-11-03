package lotto.message;

public enum LottoResultMessage {
    WINNING_STATISTICS("당첨 통계"),
    DASH_LINE("----"),
    THREE_MATCH("3개 일치 (5,000원) - 1개"),
    FOUR_MATCH("4개 일치 (50,000원) - 0개"),
    FIVE_MATCH("5개 일치 (1,500,000원) - 0개"),
    FIVE_MATCH_WITH_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - 0개"),
    SIX_MATCH("6개 일치 (2,000,000,000원) - 0개");

    private final String message;

    LottoResultMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}