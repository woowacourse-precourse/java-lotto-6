package lotto.Exception;

public enum ExceptionMessage {

    TYPE_ERROR("[ERROR] 숫자만 입력 가능합니다.");

    private final String exceptionMessage;

    ExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }
}
