package lotto.constant;

public enum ErrorMessage {
    NOT_NUMBER("입력값은 숫자여야 합니다."),
    NOT_INITIALIZED("도메인 객체가 초기화되지 않았습니다."),
    INVALID_WINNING_NUMBERS("잘못된 당첨 번호 형식입니다.");

    private static final String ERROR_PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessage(final String message) {
        this.message = ERROR_PREFIX + message;
    }

    public String toValue() {
        return this.message;
    }
}
