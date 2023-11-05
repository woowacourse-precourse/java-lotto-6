package lotto.constants;

public enum ErrorCode {
    PREFIX("[ERROR] "),
    NOT_INTEGER("입력한 값이 숫자가 아닙니다."),
    INVALID_PURCHASE_AMOUNT("로또 구입금액의 범위가 유효하지 않습니다.");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX.message + this.message;
    }
}
