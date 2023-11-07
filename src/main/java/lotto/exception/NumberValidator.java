package lotto.exception;

import java.util.List;
import lotto.util.ErrorMessage;
import lotto.util.LottoValues;

public class NumberValidator {

    public static void validate(List<Integer> numbers) {
        validateNumberCount(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
    }

    public static void validate(int bonusNumber) {
        validateRange(bonusNumber);
    }

    private static void validateNumberCount(List<Integer> numbers) {
        if (numbers.size() != LottoValues.LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_VALIDATE_NUMBER_COUNT_MESSAGE.toString());
        }
    }

    private static void validateDuplicate(List<Integer> numbers) {
        long uniqueCount = numbers.stream().distinct().count();
        if (uniqueCount < numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_VALIDATE_NUMBER_DUPLICATE_MESSAGE.toString());
        }
    }

    private static void validateRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if(isInRange(number)){
                throw new IllegalArgumentException(ErrorMessage.ERROR_VALIDATE_NUMBER_IN_RANGE_MESSAGE.toString());
            }
        }
    }

    private static void validateRange(int bonusNumber) {
        if(isInRange(bonusNumber)){
            throw new IllegalArgumentException(ErrorMessage.ERROR_VALIDATE_NUMBER_IN_RANGE_MESSAGE.toString());
        }
    }

    private static boolean isInRange(Integer number) {
        return number > LottoValues.MAX_LOTTO_NUMBER || number < LottoValues.MIN_LOTTO_NUMBER;
    }
}
