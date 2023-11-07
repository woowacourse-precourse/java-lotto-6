package lotto.io.write;

public enum OutputMessage {

    LOTTO_PURCHASE_AMOUNT_MESSAGE("개를 구매했습니다."),
    LOTTO_PROFIT_MESSAGE("총 수익률은 %.1f%%입니다."),
    LOTTO_STATISTICS_MESSAGE("%s - %d개\n"),
    LOTTO_RESULT_MESSAGE("당첨 통계\n---");

    public final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
