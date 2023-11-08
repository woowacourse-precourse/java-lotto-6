package lotto.utils;

public enum ExceptionMessage {
    OUT_OF_RANGE_NUMBER("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    OUT_OF_RANGE_SIZE("[ERROR] 로또 번호 사이즈는 6입니다."),
    NOT_NUMBER("[ERROR] 숫자를 입력하세요."),
    UNIT_IS_INCORRECT("[ERROR] 1,000단위로 입력하세요"),
    NEGATIVE_NUMBER("[ERROR] 음수를 입력할 수 없습니다. 1,000원 단위로 입력해 주세요."),
    DUPLICATED_NUMBER("[ERROR] 중복되지 않은 숫자를 입력하세요.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
