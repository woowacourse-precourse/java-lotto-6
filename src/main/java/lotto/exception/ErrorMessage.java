package lotto.exception;

public enum ErrorMessage {
    NOT_INTEGER("[ERROR] 숫자가 아닙니다."),
    HAS_SPACE("[ERROR] 공백이 포함되어 있습니다."),
    HAS_REMAINING_NUMBER("[ERROR] 잔돈이 발생합니다.");

    private final String errorMessage;

    ErrorMessage (String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getMessage() {
        return errorMessage;
    }
}
