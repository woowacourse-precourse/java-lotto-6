package lotto.util.exception;

public enum ErrorMessage {

    /**
     * Lotto Message
     */
    LENGTH_GREATER_THAN_SIX("로또 번호는 6개여야 합니다."),
    DUPLICATE_NUMBERS("로또 번호에 중복된 값이 있습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
