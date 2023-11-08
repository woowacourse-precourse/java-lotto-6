package util;

public enum ValidationPriceMessages {

    NOT_A_NUMBER("[ERROR] 숫자만 입력해주세요."),
    INVALID_REMAINDER("[ERROR] 숫자는 1000단위로 입력해야 합니다."),
    NEGATIVE_NUMBER("[ERROR] 양수만 입력해야 합니다.");

    private String message;

    private ValidationPriceMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
