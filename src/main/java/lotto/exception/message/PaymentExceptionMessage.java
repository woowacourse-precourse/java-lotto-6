package lotto.exception.message;

public enum PaymentExceptionMessage {
    NOT_NUMBER("금액에는 숫자를 입력해주세요!"),
    INVALID_VALUE("0보다 더 큰 금액을 입력해주세요!"),
    INVALID_AMOUNT("1000원 단위로 금액을 입력해주세요!");
    private final String message;

    PaymentExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
