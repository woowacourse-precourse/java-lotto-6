package lotto.constant;

public enum ProgressMessage {
    PURCHASE_AMOUNT_REQUEST("구입금액을 입력해 주세요.");

    private final String message;

    ProgressMessage(final String message) {
        this.message = message;
    }

    public String toValue() {
        return this.message;
    }
}
