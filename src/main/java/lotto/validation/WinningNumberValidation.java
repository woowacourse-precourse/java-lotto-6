package lotto.validation;

import static lotto.constant.ErrorMessage.DUPLICATION_EXCEPTION;
import static lotto.constant.ErrorMessage.SIZE_EXCEPTION;
import static lotto.constant.LottoConstant.LOTTO_NUMBER_COUNT;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WinningNumberValidation {
    public static void validateWinningNumber(int[] numbers) {
        validateSize(numbers);

        Set<Integer> distinctWinningNumbers = new HashSet<>();
        Arrays.stream(numbers).forEach(number -> {
            WinningNumbersValidation.validateNumberInRange(number);
            validateDuplication(number, distinctWinningNumbers);
        });
    }

    private static void validateSize(int[] numbers) {
        if (numbers.length != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(SIZE_EXCEPTION.getMessage());
        }
    }

    private static void validateDuplication(int winningNumber, Set<Integer> distinctWinningNumbers) {
        if (!distinctWinningNumbers.add(winningNumber)) {
            throw new IllegalArgumentException(DUPLICATION_EXCEPTION.getMessage());
        }
    }
}
