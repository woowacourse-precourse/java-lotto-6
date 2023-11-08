package lotto.exception.constant;

public enum ErrorCode {
    INVALID_NUMBER_REGEX("숫자만 입력해야 합니다."),
    INVALID_LOTTO_PURCHASE("1000원 단위로 입력해야 합니다.");
    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
