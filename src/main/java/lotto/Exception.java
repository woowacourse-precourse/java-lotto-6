package lotto;

import java.util.*;

public class Exception {
    private static final String START_ERROR_MESSAGE = "[ERROR] ";
    private static final String VALIDATE_NUMBER_INPUT_MESSAGE = "숫자 이외의 값이 포함될 수 없습니다.";
    private static final String VALIDATE_ENDS_WITH_MESSAGE = "구입금액은 1,000원 단위여야 합니다.";
    private static final String VALIDATE_NUMBERS_SIZE_MESSAGE = "번호는 6개의 숫자여야 합니다.";
    private static final String VALIDATE_NUMBER_RANGE_MESSAGE = "번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String VALIDATE_DUPLICATE_NUMBER_MESSAGE = "번호는 중복되지 않아야 합니다.";

    public void validatePurchasePrice(String input) {
        validateNumberInput(input);
        validateEndsWith(input);
    }

    public void validateWinningNumbersInput(List<String> inputs) {
        for (String input : inputs) {
            validateNumberInput(input);
        }
    }

    public void validateNumberInput(String input) {
        if (!input.matches("\\d+")) {
            handleException(VALIDATE_NUMBER_INPUT_MESSAGE);
        }
    }

    private void validateEndsWith(String input) {
        if (!input.trim().endsWith("000")) {
            handleException(VALIDATE_ENDS_WITH_MESSAGE);
        }
    }

    public void validateNumbersSize(List<Integer> input) {
        if (input.size() != 6) {
            handleException(VALIDATE_NUMBERS_SIZE_MESSAGE);
        }
    }

    public void validateDuplicateNumber(List<Integer> input) {
        Set<Integer> nonDuplicateNumbers = new HashSet<>(input);
        if (nonDuplicateNumbers.size() != 6) {
            handleException(VALIDATE_DUPLICATE_NUMBER_MESSAGE);
        }
    }

    public void validateNumberRange(int input) {
        if (input < 1 || input > 45) {
            handleException(VALIDATE_NUMBER_RANGE_MESSAGE);
        }
    }

    private void handleException(String message) {
        throw new IllegalArgumentException(START_ERROR_MESSAGE + message);
    }
}
