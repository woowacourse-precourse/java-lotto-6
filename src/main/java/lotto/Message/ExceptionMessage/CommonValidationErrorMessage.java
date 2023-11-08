package lotto.Message.ExceptionMessage;

public enum CommonValidationErrorMessage {
    RANGE_ERROR_MESSAGE("1 ~ 45 사이의 숫자만 입력해 주세요. \n 입력값 : %s\n"),
    BLANK_VALUE_ERROR_MESSAGE("공백은 입력할 수 없습니다.\n"),
    INTEGER_VALUE_ERROR_MESSAGE("정수만 입력할 수 있습니다.\n 입력값 : %s\n");

    private final String message;

    CommonValidationErrorMessage(String message) {
        this.message = PrefixMessage.ERROR_MESSAGE.getMessage() + message;
    }

    public String getMessage(Integer value) {
        return String.format(this.message, value);
    }

    public String getMessage(String value) {
        return String.format(this.message, value);
    }
}
