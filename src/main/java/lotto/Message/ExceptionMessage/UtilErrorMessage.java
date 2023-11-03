package lotto.Message.ExceptionMessage;

public enum UtilErrorMessage {
    CONVERSION_ERROR_MESSAGE("[ERROR] 숫자로 변환할 수 없습니다.\n 입력값 : %s"),
    RANGE_ERROR_MESSAGE("[ERROR] 1 ~ 45 사이의 숫자만 입력해 주세요. \n 입력값 : %s"),
    BLANK_VALUE_ERROR_MESSAGE("[ERROR] 공백은 입력할 수 없습니다.\n"),
    INTEGER_VALUE_ERROR_MESSAGE("[ERROR] 정수만 입력할 수 있습니다.\n 입력값 : %s");

    private String message;

    UtilErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
