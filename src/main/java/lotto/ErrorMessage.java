package lotto;

public enum ErrorMessage {
    PREFIX("[ERROR]"),
    LOTTO_NUMBER_OUT_OF_RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    ;

    ErrorMessage(String message) {
        this.message = message;
    }

    public final String message;
}
