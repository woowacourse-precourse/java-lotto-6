package lotto.exception.defaultexception;

public enum DefaultErrorMessage {

    BLANK_INPUT("[ERROR] 입력값이 없습니다."),
    NON_NUMERIC("[ERROR] 숫자가 아닌 값이 입력되었습니다."),
    WHITE_SPACE("[ERROR] 입력값에 공백이 포함되어 있습니다.");

    private final String message;

    DefaultErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public LottoDefaultException getException() {
        return new LottoDefaultException(message);
    }
}
