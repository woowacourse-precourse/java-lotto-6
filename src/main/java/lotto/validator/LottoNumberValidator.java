package lotto.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.ErrorMessage;

public class LottoNumberValidator extends Validator {
    public final static int LOTTO_NUMBER_COUNT = 6;
    public final static int MIN_LOTTO_NUMBER = 1;
    public final static int MAX_LOTTO_NUMBER = 45;

    private static void validateNumbersCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_COUNT.getMessage());
        }
    }

    private static void hasDuplicateNumbers(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);

        if (uniqueNumbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER_MESSAGE.getMessage());
        }
    }

    private static void validateLottoNumbersRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (!validateNumberRange(number, MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER)) {
                throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_OUT_OF_RANGE_MESSAGE.getMessage());
            }
        }
    }
    public static void validateLottoNumbers(List<Integer> numbers){
        validateNumbersCount(numbers);
        hasDuplicateNumbers(numbers);
        validateLottoNumbersRange(numbers);
    }

    public static void validateSingleNumberRange(int number) {
        if (!validateNumberRange(number, MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER)) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_OUT_OF_RANGE_MESSAGE.getMessage());
        }
    }

    public static void validateDuplicatedNumber(List<Integer> numbers, int number) {
        if (numbers.contains(number)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER_MESSAGE.getMessage());
        }
    }
}
