package lotto.exception;

public enum ErrorMessage {
    NOT_INTEGER("숫자가 아닙니다."),
    INVALID_UNIT("잘못된 단위입니다."),
    NOT_ENOUGH_MONEY("돈이 충분하지 않습니다."),
    WRONG_SIZE("로또 번호 갯수가 잘못 되었습니다."),
    DUPLICATE_NUMBER("중복된 숫자가 있습니다."),
    WRONG_RANGE("숫자 범위가 잘못되었습니다.");

    private static final String header = "[ERROR] ";
    private final String message;

    ErrorMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return header + message;
    }


}
