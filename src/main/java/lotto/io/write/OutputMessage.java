package lotto.io.write;

public enum OutputMessage {

    LOTTO_PURCHASE_AMOUNT_MESSAGE("\n%d개를 구매했습니다."),
    LOTTO_PROFIT_MESSAGE("총 수익률은 %.1f%%입니다."),
    LOTTO_STATISTICS_MESSAGE("%s - %d개"),
    LOTTO_RESULT_MESSAGE("\n당첨 통계\n---");

    public final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
