package lotto;

public enum ErrorCode {
    PURCHASE_AMOUNT_ERROR("구매 금액은 1000원 단위로 입력해 주세요.");
    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
