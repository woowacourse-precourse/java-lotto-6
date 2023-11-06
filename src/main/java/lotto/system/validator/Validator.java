package lotto.system.validator;

public class Validator {
    private enum ExceptionMessage {
        EMPTY_VALUE_NOT_ALLOWED("빈 값을 입력할 수 없습니다.");
        private final String message;

        ExceptionMessage(String message) {
            this.message = message;
        }
    }

    public void validateNotEmpty(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.EMPTY_VALUE_NOT_ALLOWED.message);
        }
    }
}
