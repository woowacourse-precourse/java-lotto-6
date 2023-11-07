package lotto.global.exception;

public enum ErrorMessage {
    BLANK_INPUT_ERROR("빈 문자열이 입력되었습니다."),
    NOT_NUMBER_ERROR("숫자를 입력해주세요."),
    INVALID_UNIT_ERROR("%s원 단위의 구입 금액을 입력해주세요."),
    INVALID_SEPARATOR_ERROR("올바르지 않은 구분자 입력입니다."),
    INVALID_RANGE_ERROR("올바르지 않은 범위의 입력입니다."),
    DUPLICATED_NUMBER_ERROR("중복되지 않은 숫자를 입력해주세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
