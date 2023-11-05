package lotto.view.constant;

public enum InputMessage {

    GET_PURCHASE_AMOUNT_MESSAGE("구입금액을 입력해 주세요.");

    private String message;

    InputMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
