package lotto.util.message;

public enum ErrorMessage {

    HEAD("[ERROR] "),
    MONEY_NOT_DIVIDABLE("로또 가격으로 나누어 떨어지지 않는 금액입니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return HEAD.message + message;
    }
}