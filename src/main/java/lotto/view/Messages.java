package lotto.view;

public enum Messages {
    ASK_PURCHASE_AMOUNT_MESSAGE("구입금액을 입력해 주세요.");

    private final String message;

    Messages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
