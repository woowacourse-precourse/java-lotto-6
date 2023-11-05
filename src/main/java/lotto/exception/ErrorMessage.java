package lotto.exception;

public enum ErrorMessage {
    // Lotto Validation
    INVALID_LOTTO_NUMBER_RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    INVALID_LOTTO_NUMBER_COUNT("로또 번호는 6개여야 합니다."),
    DUPLICATE_LOTTO_NUMBER("로또 번호는 중복되지 않아야 합니다."),

    // Winning Lotto Validation
    INVALID_BONUS_NUMBER_RANGE("보너스 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATE_BONUS_NUMBER("보너스 번호가 당첨 번호와 중복되었습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    String getMessage() {
        return message;
    }
}
