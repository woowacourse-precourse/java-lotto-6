package lotto.exception;

public class InvalidLottoException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] ";

    public enum InvalidLottoError {
        INVALID_LOTTO_COUNT("로또 크기는 6개입니다."),
        INVALID_LOTTO_RANGE("로또 숫자의 범위는 1~45 입니다."),
        DUPLICATE_LOTTO("로또 숫자는 중복될 수 없습니다."),
        ;

        private final String message;

        InvalidLottoError(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }

    private final String message;

    public InvalidLottoException(InvalidLottoError error) {
        super(ERROR_MESSAGE + error.getMessage());
        this.message = error.getMessage();
    }
}
