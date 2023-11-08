package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exception {
    private static final String START_ERROR_MESSAGE = "[ERROR] ";
    private static final String VALIDATE_NUMBER_INPUT_MESSAGE = "숫자 이외의 값이 포함될 수 없습니다.";
    private static final String VALIDATE_ENDS_WITH_MESSAGE = "구입금액은 1,000원 단위여야 합니다.";
    private static final String VALIDATE_NUMBERS_SIZE_MESSAGE = "쉼표(,)를 기준으로 6개의 숫자를 입력해야 합니다.";
    private static final String VALIDATE_NUMBER_RANGE_MESSAGE = "로또 번호는 1부터 45 사이의 숫자여야 합니다.";

    public void validatePurchasePrice(String input) {
        validateNumberInput(input);
        validateEndsWith(input);
    }

    public void validateWinningNumbers(String winningNumbers) {
        List<String> winningNumber = Arrays.asList(winningNumbers.split(","));
        validateNumbersSize(winningNumber);
        for (String number: winningNumber) {
            validateNumberInput(number);
            validateNumberRange(number);
        }
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

    private void validateNumbersSize(List<String> input) {
        if (input.size() != 6) {
            handleException(VALIDATE_NUMBERS_SIZE_MESSAGE);
        }
    }

    private void validateNumberRange(String input) {
        int number = Integer.parseInt(input);
        if (number < 1 || number > 45) {
            handleException(VALIDATE_NUMBER_RANGE_MESSAGE);
        }
    }

    private void handleException(String message) {
        throw new IllegalArgumentException(START_ERROR_MESSAGE + message);
    }
}
