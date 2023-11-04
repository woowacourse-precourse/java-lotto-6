package lotto.global;

public enum ErrorMessage {

    INPUT_NUMBER_IS_INVALID("[ERROR] 유효한 숫자를 입력해주세요."),
    ;

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
