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

    public static void validateInWinningNumbers(int bonusNumber, List<Integer> winningNumbers) throws IllegalArgumentException {
        if (winningNumbers.contains(bonusNumber)) {
            System.out.println(ErrorMessage.ERROR_VALIDATE_BONUS_DUPLICATE_MESSAGE);
            throw new IllegalArgumentException();
        }
    }

    public static void validateLottoCount(int customerPrice) throws IllegalArgumentException {
        if (canChangeCountByLottoPrice(customerPrice)) {
            System.out.println(ErrorMessage.ERROR_LOTTO_COUNT_MESSAGE);
            System.out.println();
            throw new IllegalArgumentException();
        }
    }

    private static boolean canChangeCountByLottoPrice(int customerPrice) {
        return (customerPrice % LottoValues.LOTTO_PRICE != 0) || (customerPrice == 0);
    }

    public static void validateNumberCount(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != LottoValues.LOTTO_NUMBER_COUNT) {
            System.out.println(ErrorMessage.ERROR_VALIDATE_NUMBER_COUNT_MESSAGE);
            throw new IllegalArgumentException();
        }
    }

    public static void validateDuplicate(List<Integer> numbers) throws IllegalArgumentException {
        long uniqueCount = numbers.stream().distinct().count();
        if (uniqueCount < numbers.size()) {
            System.out.println(ErrorMessage.ERROR_VALIDATE_NUMBER_DUPLICATE_MESSAGE);
            throw new IllegalArgumentException();
        }
    }

    public static void validateRange(List<Integer> numbers) throws IllegalArgumentException {
        for (Integer number : numbers) {
            if (isInRange(number)) {
                System.out.println(ErrorMessage.ERROR_VALIDATE_NUMBER_IN_RANGE_MESSAGE);
                throw new IllegalArgumentException();
            }
        }
    }

    public static void validateRange(int bonusNumber) throws IllegalArgumentException {
        if (isInRange(bonusNumber)) {
            System.out.println(ErrorMessage.ERROR_VALIDATE_NUMBER_IN_RANGE_MESSAGE);
            throw new IllegalArgumentException();
        }
    }

    private static boolean isInRange(Integer number) {
        return number > LottoValues.MAX_LOTTO_NUMBER || number < LottoValues.MIN_LOTTO_NUMBER;
    }
}
