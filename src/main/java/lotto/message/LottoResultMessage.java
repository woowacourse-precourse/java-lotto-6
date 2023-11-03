package lotto.message;

public enum LottoResultMessage {
    WINNING_STATISTICS("당첨 통계"),
    DASH_LINE("---"),
    THREE_MATCH_FORMAT("3개 일치 (5,000원) - %s개\n"),
    FOUR_MATCH_FORMAT("4개 일치 (50,000원) - %s개\n"),
    FIVE_MATCH_FORMAT("5개 일치 (1,500,000원) - %s개\n"),
    FIVE_MATCH_WITH_BONUS_FORMAT("5개 일치, 보너스 볼 일치 (30,000,000원) - %s개\n"),
    SIX_MATCH_FORMAT("6개 일치 (2,000,000,000원) - %s개\n"),
    TOTAL_PROFIT_FORMAT("총 수익률은 62.5%입니다.");

    private final String message;

    LottoResultMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}