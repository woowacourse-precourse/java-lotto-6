package lotto.utils;

public enum ErrorMessage {
    INVALID_LOTTO_PAYMENT("로또 구입 금액은 1000원 이상이어야 합니다."),
    DUPLICATED_LOTTO_NUMBER("로또 번호는 중복될 수 없습니다."),
    INVALID_LOTTO_NUMBER("로또 번호는 1부터 45 사이의 숫자여야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR] " + message;
    }

}
