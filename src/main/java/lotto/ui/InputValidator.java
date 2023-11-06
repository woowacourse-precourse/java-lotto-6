package lotto.ui;

public class InputValidator {
    private static final int AMOUNT_UNIT = 1000;
    private static final int AMOUNT_LIMIT = 100000;
    private final String commonErrorMessage = ErrorMessage.COMMON_MESSAGE.getMessage();

    public int validateAmount(String input) throws IllegalArgumentException {
        validateNonEmpty(input);
        validateNumericFormat(input);
        int amount = convertToInt(input);
        validateNonZero(amount);
        validateUnit(amount);
        validateLimit(amount);

        return amount;
    }

    private void validateNonEmpty(String input) throws IllegalArgumentException {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(createErrorMessage(ErrorMessage.EMPTY_ERROR));
        }
    }

    private void validateNumericFormat(String input) throws IllegalArgumentException {
        if (!input.matches("^[0-9]\\d*$")) {
            throw new IllegalArgumentException(createErrorMessage(ErrorMessage.NUMERIC_ERROR));
        }
    }

    private int convertToInt(String input) throws IllegalArgumentException {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(createErrorMessage(ErrorMessage.AMOUNT_LIMIT_ERROR));
        }
    }

    private void validateNonZero(int amount) throws IllegalArgumentException {
        if (amount == 0) {
            throw new IllegalArgumentException(createErrorMessage(ErrorMessage.AMOUNT_UNIT_ERROR));
        }
    }

    private void validateUnit(int amount) throws IllegalArgumentException {
        if (amount % AMOUNT_UNIT != 0) {
            throw new IllegalArgumentException(createErrorMessage(ErrorMessage.AMOUNT_UNIT_ERROR));
        }
    }

    private void validateLimit(int amount) throws IllegalArgumentException {
        if (amount > AMOUNT_LIMIT) {
            throw new IllegalArgumentException(createErrorMessage(ErrorMessage.AMOUNT_LIMIT_ERROR));
        }
    }

    private String createErrorMessage(ErrorMessage errorMessage) {
        return errorMessage.getMessage() + " " + commonErrorMessage;
    }
}