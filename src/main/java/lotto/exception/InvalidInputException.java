package lotto.exception;

public class InvalidInputException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] ";

    public enum InvalidInputError {
        INPUT_NOT_BLANK("공백 입력은 안됩니다."),
        NUMBER_NEED("숫자 입력이 필요합니다."),
        POSITIVE_NUMBER_NEED("양수 입력이 필요합니다."),
        INVALID_AMOUNT("구입 금액은 1000으로 나누어 떨어져야 합니다."),
        ;

        private final String message;

        InvalidInputError(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }

    private final String message;

    public InvalidInputException(InvalidInputError error) {
        super(ERROR_MESSAGE + error.getMessage());
        this.message = error.getMessage();
    }
}
