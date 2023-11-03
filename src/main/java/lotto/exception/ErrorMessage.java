package lotto.exception;

public enum ErrorMessage {

    ERROR("[ERROR]"),
    IS_NOT_MULTIPLE_OF_THOUSAND("1000원 단위로 입력해주세요."),
    EMPTY("값이 입력되지 않았습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
