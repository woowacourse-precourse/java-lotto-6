package lotto.constant;

public enum ProcessMessage {
    PURCHASE_AMOUNT_REQUSET("구입금액을 입력해 주세요.");

    private final String message;

    ProcessMessage(String message) {
        this.message = message;
    }

    public String toValue() {
        return this.message;
    }

}
