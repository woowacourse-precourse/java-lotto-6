package lotto.Constant;

public enum OutputMessage {
    REQUEST_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    REQUEST_WINNING_NUMBERS("\n당첨 번호를 입력해 주세요."),
    REQUEST_BONUS_NUMBER("\n보너스 번호를 입력해 주세요."),
    PURCHASED_LOTTO_QUANTITY("\n%d개를 구매했습니다."),
    LOTTO_NUMBERS("%s"),
    RESULTS_HEADER("\n당첨 통계\n---"),
    RESULT_LINE("%d개 일치 (%s원) - %d개\n"),
    RESULT_SECOND("5개 일치, 보너스 볼 일치 (%s원) - %d개"),
    PROFIT_RATE("총 수익률은 %s%%입니다."),
    ERROR_MESSAGE("%s"),
    NEW_LINE("\n");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String format(Object... args) {
        return String.format(message, args);
    }
}
