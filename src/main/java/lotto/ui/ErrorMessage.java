package lotto.ui;

public enum ErrorMessage {
    COMMON_MESSAGE("다시 입력해 주세요."),
    EMPTY_ERROR("[ERROR] 입력값이 없습니다."),
    NUMERIC_ERROR("[ERROR] 숫자만 입력할 수 있습니다."),
    AMOUNT_LIMIT_ERROR("[ERROR] 최대한도는 100,000원입니다."),
    AMOUNT_UNIT_ERROR("[ERROR] 1,000원 단위로 입력해 주세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}