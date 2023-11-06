package lotto.constant;

public enum Message {
    PURCHASE_AMOUNT_PROMPT("구입금액을 입력해 주세요."),
    PURCHASE_AMOUNT_MESSAGE("%d개를 구매했습니다."),
    WINNING_NUMBER_PROMPT("당첨 번호를 입력해 주세요.");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
