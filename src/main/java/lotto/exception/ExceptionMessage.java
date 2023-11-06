package lotto.exception;

public enum ExceptionMessage {

    COMMON_ERROR_MESSAGE_FORMAT("[ERROR] : "),
    NOT_INTEGER_ERROR("금액은 정수 형태로 입력해야 합니다."),
    EMPTY_INPUT_ERROR(" : 값을 입력해야 합니다."),
    EMPTY_SPACE_INCLUDE_ERROR(" : 공백 없이 입력해야 합니다."),
    NOT_VALID_GIVEN_PRICE_ERROR("유효하지 않은 구입 금액입니다. 1000원 단위로 입력해주세요.");
    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return COMMON_ERROR_MESSAGE_FORMAT + message;
    }
}
