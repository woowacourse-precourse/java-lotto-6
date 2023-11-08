package lotto.exception;

/**
 * Lotto 객체 생성시 예외값 정의 enum
 */
public enum LottoExceptionMessage {
    INVALID_LOTTO_LENGTH("[ERROR] 로또 번호는 6자리여야 합니다."),
    INVALID_LOTTO_DUPLICATED("[ERROR] 로또 번호는 중복되지 않은 숫자로 이루어져야 합니다.");

    private final String message;

    LottoExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return message;
    }
}
