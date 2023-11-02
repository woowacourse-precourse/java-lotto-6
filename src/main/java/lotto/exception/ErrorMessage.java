package lotto.exception;

public enum ErrorMessage {
    NOT_POSITIVE_INTEGER("양의 정수만 입력가능합니다."),
    INVALID_UNIT("잘못된 단위입니다."),
    NOT_ENOUGH_MONEY("돈이 충분하지 않습니다.");

    private final String message;
    private static final String header = "[ERROR] ";

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return header + message;
    }


}
