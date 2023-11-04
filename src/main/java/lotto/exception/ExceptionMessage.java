package lotto.exception;

public enum ExceptionMessage {
    DUPLICATE_NUMBER("로또 번호는 중복되지 않는 6개의 숫자여야 합니다."),
    OUT_OF_RANGE("로또 번호의 숫자 범위는 1 ~ 45까지이다."),
    NOT_INTEGER_VALUE("번호와 금액은 정수여야 합니다."),
    EXCEEDED_LOTTO_SIZE("로또는 6개의 숫자여야 합니다.");
    private final String message;
    private static final String PREFIX = "[ERROR] ";

    ExceptionMessage(String message) {
        this.message = PREFIX + message;
    }

    public String getMessage(){
        return message;
    }
}
