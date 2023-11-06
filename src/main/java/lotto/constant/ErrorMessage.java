package lotto.constant;

public enum ErrorMessage {
    ENTER_MORE_THAN_SIX("6개 초과 입력하였습니다.");

    private final String message;

    ErrorMessage(final String message) {
        this.message = message;
    }

    public final String getMessage() {
        return message;
    }
}
