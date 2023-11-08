package lotto.constant.message;

public enum OutputMessage {
    PURCHASE_LOTTO("개를 구매했습니다."),
    RESULT_START("\n당첨 통계\n---"),
    RESULT_LOTTO("%d개 일치 (%s원) - %d개\n"),
    RESULT_BONUS("5개 일치, 보너스 볼 일치 (%s원) - %d개\n"),
    PROFIT_RATE("총 수익률은 %.1f%%입니다."),
    DELIMITER(", "),
    PREFIX("["),
    SUFFIX("]");


    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
