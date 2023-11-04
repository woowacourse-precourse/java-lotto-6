package lotto.constant;

public enum OutputMessage {
    OUTPUT_PURCHASE_AMOUNT_MESSAGE("개를 구매했습니다."),
    RESULT_MESSAGE("당첨 통계\n---"),
    OUTPUT_LOTTO_STATUS_MESSAGE("%d개 일치 (%s원) - %d개"),
    OUTPUT_LOTTO_WITH_BONUS_STATUS_MESSAGE("%d개 일치, 보너스 볼 일치 (%s원) - %d개"),
    OUTPUT_LOTTO_RETURN_RATE_MESSAGE("총 수익률은 %.1f%%입니다.");;

    private final String Message;

    OutputMessage(String message) {
        Message = message;
    }

    public String getMessage() {
        return Message;
    }
}
