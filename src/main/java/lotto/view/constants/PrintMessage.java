package lotto.view.constants;

public enum PrintMessage {
    /**
     * Reqeust
     */
    REQUEST_PURCHASE_PAYMENT("구입금액을 입력해주세요."),


    /**
     * Response
     */
    RESPONSE_PURCHASE_COUNT("%d개를 구매했습니다."),
    RESPONSE_LOTTO_RESULT("[%s]");

    private final String message;

    PrintMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
