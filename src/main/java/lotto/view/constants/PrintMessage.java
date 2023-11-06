package lotto.view.constants;

public enum PrintMessage {
    /**
     * Reqeust
     */
    REQUEST_PURCHASE_PAYMENT("구입금액을 입력해주세요."),
    REQUEST_JACKPOT_NUMBER("당첨 번호를 입력해주세요."),
    REQUEST_JACKPOT_BONUS_NUMBER("보너스 번호를 입력해주세요."),


    /**
     * Response
     */
    RESPONSE_PURCHASE_COUNT("%d개를 구매했습니다."),
    RESPONSE_LOTTO_RESULT("[%s]"),
    RESPONSE_PRIZE_STATISTICS("당첨 통계"),
    RESPONSE_SEPARATOR("---"),
    RESPONSE_YIELD("총 수익률은 %s%%입니다.");

    private final String message;

    PrintMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
