package lotto.exception;

public enum PaymentExceptionMessage {
    NOT_NUMBER ("금액에는 숫자를 입력해주세요!"),
    INVALID_VALUE ("0보다 더 큰 숫자를 입력해주세요!");
    private final String message;
    PaymentExceptionMessage(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}
