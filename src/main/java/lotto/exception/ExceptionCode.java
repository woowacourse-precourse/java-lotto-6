package lotto.exception;

public enum ExceptionCode {
    INVALID_INPUT_INTEGER("INPUT_001", "[ERROR] 입력 값은 0이상의 정수여야 합니다.");

    private final String code;
    private final String message;

    private ExceptionCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return message;
    }
}
