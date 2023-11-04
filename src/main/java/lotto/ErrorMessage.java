package lotto;

public enum ErrorMessage {
    OUT_OF_SIZE("로또 숫자의 개수가 6개가 아닙니다."),
    DUPLICATE_NUMBER("로또 숫자가 중복됩니다."),
    NOT_IN_RANGE("로또 숫자가 1-45 사이의 숫자가 아닙니다."),
    NOT_SORT("로또 숫자가 정렬되어 있지 않습니다."),
    ;

    private final String message;

    ErrorMessage(final String message) {
        this.message = message;
    }

    public final String getMessage() {
        return message;
    }
}
