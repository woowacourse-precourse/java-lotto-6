package lotto.view.constant;

public enum Message {
    ASK_PURCHASE_MONEY("구입금액을 입력해 주세요."),
    ASK_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    NOTICE_PURCHASE_QUANTITY("%d개를 구매했습니다.");
    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
