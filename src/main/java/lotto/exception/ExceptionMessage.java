package lotto.exception;

public enum ExceptionMessage {
    INVALID_NUMBER("1000원 단위의 숫자를 입력하세요.");

    private final String errorMessage;

    ExceptionMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
