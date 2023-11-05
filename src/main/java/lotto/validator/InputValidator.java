package lotto.validator;

import lotto.validator.ErrorMessage.ErrorMessages;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class InputValidator {
    private static final String ERROR_MESSAGE = ErrorMessages.ERROR_MESSAGES.getMessage();
    private static final String EMPTY_INPUT_EXCEPTION_MESSAGE = ErrorMessages.EMPTY_INPUT_EXCEPTION_MESSAGE.getMessage();
    private static final String NOT_DIVIDED_THOUSAND_EXCEPTION = ErrorMessages.NOT_DIVIDED_THOUSAND_EXCEPTION_MESSAGE.getMessage();
    private static final String NOT_IN_RIGHT_RANGE_EXCEPTION_MESSAGE = ErrorMessages.NOT_IN_RIGHT_RANGE_EXCEPTION_MESSAGE.getMessage();
    private static final String NOT_NUMBER_EXCEPTION_MESSAGE = ErrorMessages.NOT_NUMBER_EXCEPTION_MESSAGE.getMessage();
    private static final String NOT_RIGHT_AMOUNT_OF_WINNING_LOTTO = ErrorMessages.NOT_RIGHT_AMOUNT_OF_WINNING_NUMBER_EXCEPTION_MESSAGE.getMessage();
    private static final String DUPLICATED_NUMBER_EXCEPTION_MESSAGE = ErrorMessages.DUPLICATED_NUMBER_EXCEPTION_MESSAGE.getMessage();

    public static void validateInputIsEmpty(String input) {
        if (input.isBlank()) {
            throw new IllegalStateException(ERROR_MESSAGE+ EMPTY_INPUT_EXCEPTION_MESSAGE);
        }
    }

    public static void validateInputIsNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE+ NOT_NUMBER_EXCEPTION_MESSAGE);
        }
    }

    public static void validateInputNumberIsNotDividedThousand(String input) {
        if (Integer.parseInt(input) % 1000 != 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE+ NOT_DIVIDED_THOUSAND_EXCEPTION);
        }
    }

    public static void validateLottoNumberIsNotInRightRange(String input) {
        int num = Integer.parseInt(input);
        if (num < 1 || num > 45) {
            throw new IllegalArgumentException(ERROR_MESSAGE+ NOT_IN_RIGHT_RANGE_EXCEPTION_MESSAGE);
        }
    }

    public static void validateAmountOfWinningLottoNumber(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalStateException(ERROR_MESSAGE + NOT_RIGHT_AMOUNT_OF_WINNING_LOTTO);
        }
    }

    public static void validateDuplicatedWinningLottoNumber(List<Integer> winningNumbers) {
        Set<Integer> set = winningNumbers.stream().collect(Collectors.toSet());
        if (set.size() != winningNumbers.size()) {
            throw new IllegalStateException(ERROR_MESSAGE + DUPLICATED_NUMBER_EXCEPTION_MESSAGE);
        }
    }
}
