package lotto.constants;

public enum ErrorCode {
    AMOUNT_FORMAT(1, "[ERROR] 구입 금액은 정수(1000원 이상 2,147,483,000원 이하)로 입력해주세요."),
    AMOUNT_UNIT(2, "[ERROR] 구입 금액은 1000원 단위로 입력해주세요."),
    AMOUNT_INVALID(3, "[ERROR] 구입 금액은 1000원 이상으로 입력해주세요.");


    private final int code;
    private final String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
