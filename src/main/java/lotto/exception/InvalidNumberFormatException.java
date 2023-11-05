package lotto.exception;

import lotto.constant.ErrorMessageConstants;

public class InvalidNumberFormatException extends NumberFormatException {
    public enum ErrorMessage {
        NUMBER("숫자를 입력해 주세요.");
        private final String message;

        ErrorMessage(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
    public InvalidNumberFormatException(String message) {
        super(ErrorMessageConstants.ERROR_PREFIX.getMessage() + message);
    }
}
