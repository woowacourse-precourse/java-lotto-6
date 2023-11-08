package lotto.util.exception;

public enum ErrorCode {
    INVALID_BONUS_NUMBER_TYPE("보너스 번호는 정수값이어야 합니다."),
    INVALID_BONUS_NUMBER_RANGE("보너스 번호는 1부터 45 사이의 숫자여야 합니다."),
    NULL_OR_EMPTY_BONUS_NUMBER("보너스 번호는 null이나 공백이 들어갈 수 없습니다."),
    DUPLICATE_BONUS_NUMBER("보너스 번호는 당첨 번호와 중복될 수 없습니다.");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR] " + message;
    }
}
