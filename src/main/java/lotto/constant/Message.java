package lotto.constant;

public enum Message {
    INPUT_PRICE("구입금액을 입력해 주세요."),
    PURCHASE_COUNT("개를 구매했습니다."),
    INPUT_WINNING_NUMBERS("당첨 번호를 입력해 주세요.");

    private String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
