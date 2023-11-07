package lotto.exception;

import java.util.List;
import lotto.util.ErrorMessage;
import lotto.util.LottoValues;

public class NumberValidator {

    public static void validate(List<Integer> numbers) throws IllegalArgumentException {
        validateNumberCount(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
    }

    public static void validate(int bonusNumber, List<Integer> winningNumbers) throws IllegalArgumentException {
        validateRange(bonusNumber);
        validateInWinningNumbers(bonusNumber,winningNumbers);
    }

    private static void validateInWinningNumbers(int bonusNumber, List<Integer> winningNumbers) throws IllegalArgumentException {
        if (winningNumbers.contains(bonusNumber)) {
            System.out.println(ErrorMessage.ERROR_VALIDATE_BONUS_DUPLICATE_MESSAGE);
            throw new IllegalArgumentException();
        }
    }

    private static void validateNumberCount(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != LottoValues.LOTTO_NUMBER_COUNT) {
            System.out.println(ErrorMessage.ERROR_VALIDATE_NUMBER_COUNT_MESSAGE);
            throw new IllegalArgumentException();
        }
    }

    private static void validateDuplicate(List<Integer> numbers) throws IllegalArgumentException {
        long uniqueCount = numbers.stream().distinct().count();
        if (uniqueCount < numbers.size()) {
            System.out.println(ErrorMessage.ERROR_VALIDATE_NUMBER_DUPLICATE_MESSAGE);
            throw new IllegalArgumentException();
        }
    }

    private static void validateRange(List<Integer> numbers) throws IllegalArgumentException {
        for (Integer number : numbers) {
            if (isInRange(number)) {
                System.out.println(ErrorMessage.ERROR_VALIDATE_NUMBER_IN_RANGE_MESSAGE);
                throw new IllegalArgumentException();
            }
        }
    }

    private static void validateRange(int bonusNumber) {
        if (isInRange(bonusNumber)) {
            System.out.println(ErrorMessage.ERROR_VALIDATE_NUMBER_IN_RANGE_MESSAGE);
            throw new IllegalArgumentException();
        }
    }

    private static boolean isInRange(Integer number) {
        return number > LottoValues.MAX_LOTTO_NUMBER || number < LottoValues.MIN_LOTTO_NUMBER;
    }
}
