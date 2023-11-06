package lotto.constant;

public enum Error {

    INVALID_RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");

    private final String message;

    Error(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
