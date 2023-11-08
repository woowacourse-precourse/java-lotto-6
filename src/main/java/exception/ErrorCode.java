package exception;

public enum ErrorCode {
    DUPLICATE_WINNING_NUMBER("[ERROR] 중복되지않은 숫자를 입력해주세요."),
    OUT_OF_RANGE("[ERROR] 1이상 45이하의 숫자를 입력해 주세요."),
    PARS_EERROR_TYPE("[ERROR] 숫자로 입력해 주세요."),
    DIVISIBILITY_ERROR("[ERROR] 잔돈이 발생합니다. 1000으로 나누어떨어지는 수를 입력하세요.");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
