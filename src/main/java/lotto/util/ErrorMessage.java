package lotto.util;

public enum ErrorMessage {
    LOTTO_NUMBER_COUNT("[ERROR] 로또 번호는 반드시 6개여야 합니다."),
    LOTTO_NUMBER_IN_RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    LOTTO_NUMBER_UNIQUE("[ERROR] 로또 번호는 중복될 수 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
