package lotto.util;

import java.util.List;

public class InputValidator {
    private static final String NOT_A_NUMBER_MESSAGE = "입력은 숫자여야 합니다";
    private static final String WINNING_NUMBERS_SIZE_6_REQUIRED = "당첨 번호는 6개여야합니다";
    private static final String WINNING_NUMBERS_RANGE_ERROR = "당첨 번호는 1~45 사이의 숫자여야합니다";
    private static final String NUMBER_REGEX = "[0-9]+";

    public void validateIsNumber(String input) {
        if (isNumber(input) == false) {
            throw new IllegalArgumentException(NOT_A_NUMBER_MESSAGE);
        }
    }

    private boolean isNumber(String inputPrice) {
        if (inputPrice.matches(NUMBER_REGEX)) {
            return true;
        }

        return false;
    }

    public void validateWinningNumbers(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException(WINNING_NUMBERS_SIZE_6_REQUIRED);
        }

        validateNumberRange(winningNumbers);

        if (hasDuplicateNumber(winningNumbers)) {
            throw new IllegalArgumentException(WINNING_NUMBERS_RANGE_ERROR);
        }
    }

    private void validateNumberRange(List<Integer> winningNumbers) {
        for (Integer number : winningNumbers) {
            validateNumberRange(number);
        }
    }

    private void validateNumberRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(WINNING_NUMBERS_RANGE_ERROR);
        }
    }

    private boolean hasDuplicateNumber(List<Integer> winningNumbers) {
        long removeDuplicatedSize = winningNumbers.stream().distinct().count();
        if (winningNumbers.size() != removeDuplicatedSize) {
            return true;
        }

        return false;
    }
}
