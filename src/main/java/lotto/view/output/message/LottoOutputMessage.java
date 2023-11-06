package lotto.view.output.message;

public enum LottoOutputMessage {
    WINNING_STATISTICS("당첨 통계"),
    DASH_LINE("---"),
    TOTAL_PROFIT_FORMAT("총 수익률은 %.1f%%입니다."),
    PURCHASED_LOTTO_COUNT_MESSAGE_FORMAT("%s개를 구매했습니다.");

    private final String message;

    LottoOutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
