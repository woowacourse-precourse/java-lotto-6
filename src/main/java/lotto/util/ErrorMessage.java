package lotto.util;

public enum ErrorMessage {
    INVALID_NUMBER_COUNT("[ERROR] 로또 번호가 6개가 아닙니다."),
    DUPLICATE_NUMBER("[ERROR] 로또 번호에 중복된 숫자가 있습니다."),
    INVALID_NUMBER_RANGE("[ERROR] 1~45 범위의 숫자만 가능합니다."),
    INVALID_INTEGER_INPUT("[ERROR] 정수를 입력해 주세요"),
    INVALID_DIVISION_AMOUNT("[ERROR] 1000원으로 나누어 떨어지는 수여야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}