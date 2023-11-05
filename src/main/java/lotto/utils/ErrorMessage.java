package lotto.utils;

public enum ErrorMessage {
    INVALID_LOTTO_PAYMENT("로또 구입 금액은 1000원 이상이어야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
