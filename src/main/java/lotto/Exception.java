package lotto;

public class Exception {
    private static final String START_ERROR_MESSAGE = "[ERROR] ";
    private static final String VALIDATE_NUMBER_INPUT_MESSAGE = "구입금액은 숫자 이외의 값이 포함될 수 없습니다.";
    private static final String VALIDATE_ENDS_WITH_MESSAGE = "구입금액은 1,000원 단위여야 합니다.";

    public void validatePurchaseAmount(String input) {
        validateNumberInput(input);
        validateEndsWith(input);
    }

    private void validateNumberInput(String input) {
        if (!input.matches("\\d+")) {
            handleException(VALIDATE_NUMBER_INPUT_MESSAGE);
        }
    }

    private void validateEndsWith(String input) {
        if (!input.trim().endsWith("000")) {
            handleException(VALIDATE_ENDS_WITH_MESSAGE);
        }
    }

    private void handleException(String message) {
        throw new IllegalArgumentException(START_ERROR_MESSAGE + message);
    }
}
