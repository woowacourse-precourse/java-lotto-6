package lotto.error;

public enum ErrorMessage {
    INVALID_LOTTO_PURCHASE_AMOUNT("유효하지 않은 로또 구매 금액을 입력했습니다.");

    private String message;

    private ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
