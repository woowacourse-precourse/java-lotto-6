package exception;

public enum ErrorCode {

    PARSEERRORTYPE("[ERROR] 숫자로 입력해 주세요"),
    DIVISIBILITYERROR("[ERROR] 잔돈이 발생합니다. 1000으로 나누어떨어지는 수를 입력하세요");

    private final String message;

    private ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
