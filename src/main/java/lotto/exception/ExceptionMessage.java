package lotto.exception;

public enum ExceptionMessage {
    NOT_NUMBER("숫자를 입력하여주세요."),
    INVALID_LOTTO_NUMBER_RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage(){
        return "[ERROR] " + this.message;
    }


}
