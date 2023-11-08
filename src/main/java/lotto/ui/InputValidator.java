package lotto.ui;

import lotto.domain.LottoNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

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

    public List<Integer> validateWinningNumbers(String input) throws IllegalArgumentException {
        validateNonEmpty(input);
        validateWinningNumberFormat(input);
        List<Integer> winningNumbers = convertToList(input);

        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException(createErrorMessage(ErrorMessage.NUMBER_SIZE_ERROR));
        }
        for (Integer number : winningNumbers) {
            validateRange(number);
        }

        return winningNumbers;
    }

    private void validateWinningNumberFormat(String input) throws IllegalArgumentException {
        if (!input.matches("^[0-9]+(,[0-9]+){0,5}$")) {
            throw new IllegalArgumentException(createErrorMessage(ErrorMessage.NUMBER_FORMAT_ERROR));
        }
    }

    private List<Integer> convertToList(String input) throws IllegalArgumentException {
        List<Integer> winningNumbers = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(input, ",");
        if (!tokenizer.hasMoreTokens()) {
            throw new IllegalArgumentException(createErrorMessage(ErrorMessage.NUMBER_FORMAT_ERROR));
        }
        while (tokenizer.hasMoreTokens()) {
            try {
                int number = Integer.parseInt(tokenizer.nextToken());
                winningNumbers.add(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(createErrorMessage(ErrorMessage.NUMBER_FORMAT_ERROR));
            }
        }
        return winningNumbers;
    }

    private void validateRange(int number) throws IllegalArgumentException {
        if (number < LottoNumber.MIN.getValue() ||
                number > LottoNumber.MAX.getValue()) {
            throw new IllegalArgumentException(createErrorMessage(ErrorMessage.NUMBER_RANGE_ERROR));
        }
    }

    public int validateBonusNumber(String input) throws IllegalArgumentException {
        validateNonEmpty(input);
        validateNumericFormat(input);
        int bonusNumber = convertToInt(input);
        validateRange(bonusNumber);
        return bonusNumber;
    }

    private String createErrorMessage(ErrorMessage errorMessage) {
        return errorMessage.getMessage() + " " + commonErrorMessage;
    }
}