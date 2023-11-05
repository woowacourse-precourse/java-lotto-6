package lotto.utils;

public enum ExceptionMessage {
    OUT_OF_RANGE_NUMBER("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    OUT_OF_RANGE_SIZE("[ERROR] 로또 번호 사이즈는 6입니다."),
    INPUT_ONLY_NUMBER("[ERROR] 숫자를 입력하세요.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
