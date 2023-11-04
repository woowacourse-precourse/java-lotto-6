package lotto.constant;

public enum PrintMessage {
    PAYMENT_REQUEST("구입금액을 입력해 주세요."),
    AMOUT_LOTTO("개를 구매했습니다.");

    private String message;

    private PrintMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
