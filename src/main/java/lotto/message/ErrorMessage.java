package lotto.message;

public enum ErrorMessage {
    LOTTO_NUMBER_IS_NOT_IN_RANGE("[ERROR] 로또 번호의 숫자 범위는 1~45까지이다.");
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
