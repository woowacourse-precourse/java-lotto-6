package lotto.view.constants;

public enum PrintMessage {
    /**
     * Reqeust
     */
    PRINT_REQUEST_PURCHASE_PAYMENT("구입 금액을 입력해주세요."),


    /**
     * Response
     */
    PRINT_RESPONSE_PURCHASE_COUNT("%d개를 구매했습니다.");

    private final String message;

    PrintMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
