package lotto.constant;

public enum InputMessage {
    INPUT_PURCHASE_PRICE("구입금액을 입력해 주세요.");

    private final String Message;

    InputMessage(String message) {
        Message = message;
    }

    public String getMessage() {
        return Message;
    }
}
