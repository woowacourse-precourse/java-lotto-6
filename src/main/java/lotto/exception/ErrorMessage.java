package lotto.exception;

public enum ErrorMessage {
    INVALID_LOTTO_NUMBER_RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
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
