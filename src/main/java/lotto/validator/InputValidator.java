package lotto.validator;

import lotto.validator.ErrorMessage.ErrorMessage;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class InputValidator {
    public static void validateInputIsEmpty(String input) {
        if (input.isBlank()) {
            throw new IllegalStateException(ErrorMessage.EMPTY_INPUT_EXCEPTION_MESSAGE);
        }
    }

    public static void validateInputIsNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalStateException(ErrorMessage.NOT_NUMBER_EXCEPTION_MESSAGE);
        }
    }


    public static void validateLottoNumberIsNotInRightRange(String input) {
        int num = Integer.parseInt(input);
        if (num < 1 || num > 45) {
            throw new IllegalArgumentException(ErrorMessage.NOT_IN_RIGHT_RANGE_EXCEPTION_MESSAGE);
        }
    }

    public static void validateAmountOfWinningLottoNumber(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.NOT_RIGHT_AMOUNT_OF_WINNING_NUMBER_EXCEPTION_MESSAGE);
        }
    }

    public static void validateDuplicatedWinningLottoNumber(List<Integer> winningNumbers) {
        Set<Integer> set = winningNumbers.stream().collect(Collectors.toSet());
        if (set.size() != winningNumbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_NUMBER_EXCEPTION_MESSAGE);
        }
    }

    public static void validateIsWinningLottoNumberContains(String bonusLottoNumber, List<Integer> winningLotto) {
        if (winningLotto.contains(Integer.parseInt(bonusLottoNumber))) {
            throw new IllegalStateException(ErrorMessage.WINNING_LOTTO_CONTAINS_EXCEPTION_MESSAGE);
        }
    }
}
