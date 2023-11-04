package lotto.message;

public enum LottoResultMessage {
    WINNING_STATISTICS("당첨 통계"),
    DASH_LINE("---"),
    TOTAL_PROFIT_FORMAT("총 수익률은 62.5%입니다.");

    private final String message;

    LottoResultMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}