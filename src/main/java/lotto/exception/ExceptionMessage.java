package lotto.exception;

public enum ExceptionMessage {

    COMMON_ERROR_MESSAGE_FORMAT("[ERROR] : "),
    NOT_VALID_GIVEN_PRICE_ERROR("유효하지 않은 구입 금액입니다. 1000원 단위로 입력해주세요.");
    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return COMMON_ERROR_MESSAGE_FORMAT + message;
    }
}
