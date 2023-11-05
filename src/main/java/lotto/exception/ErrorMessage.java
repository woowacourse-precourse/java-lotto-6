package lotto.exception;

public enum ErrorMessage {
    INVALID_PAYMENT_RANGE("[ERROR] 구입금액은 로또 개당 가격 이상이어야 합니다."),
    INVALID_PAYMENT_FORM("[ERROR] 구입금액은 로또 개당 가격으로 나누어 떨어져야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
