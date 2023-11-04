package lotto.exception;

public enum ErrorMessage {

    ERROR_NUMBER_RANGE(
            "[ERROR] 로또 번호는 " + Constant.LOTTO_NUMBER_MIN + "부터 " + Constant.LOTTO_NUMBER_MAX + " 사이의 숫자여야 합니다.");


    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage(String... args) {
        return String.format(message, (Object) args);
    }
}
