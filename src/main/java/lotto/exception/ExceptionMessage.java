package lotto.exception;

public enum ExceptionMessage {
    DUPLICATE_NUMBER("로또 번호는 중복되지 않는 6개의 숫자여야 합니다."),
    OUT_OF_RANGE("로또 번호의 숫자 범위는 1 ~ 45까지이다.");
    private final String message;
    private final String ERROR = "[ERROR] ";

    ExceptionMessage(String message) {
        this.message = ERROR + message;
    }

    public String getMessage(){
        return message;
    }
}
