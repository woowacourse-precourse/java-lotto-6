package lotto.view.constants;

public enum ViewMessage {
    GET_PURCHASE_AMOUNT_MESSAGE("구입금액을 입력해 주세요.");

    private final String message;

    ViewMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
