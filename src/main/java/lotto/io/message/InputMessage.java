package lotto.io.message;

public enum InputMessage {

    READ_PURCHASE_AMOUNT_MESSAGE("구입금액을 입력해 주세요.");

    public final String message;

    InputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
