package lotto.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.ErrorMessage;

public class LottoNumberValidator extends Validator {
    private final static int LOTTO_NUMBER_COUNT = 6;
    private final static int MIN_LOTTO_NUMBER = 1;
    private final static int MAX_LOTTO_NUMBER = 45;

    public static void validateNumbersCount(List<Integer> numbers){
        if(numbers.size()!=6){
            throw new IllegalArgumentException(ErrorMessage.UNCORRECT_NUMBER_COUNT.getMessage());
        }
    }
    public static void hasDuplicateNumbers(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);

        if (uniqueNumbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER_MESSAGE.getMessage());
        }
    }

    public static void validateLottoNumbersRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (!validateNumberRange(number, MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER)) {
                throw new IllegalArgumentException(ErrorMessage.LOTTONUMBER_OUT_OF_RANGE_MESSAGE.getMessage());
            }
        }
    }

    public static void validateSingleNumberRange(int number) {
        if (!validateNumberRange(number, MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER)) {
            throw new IllegalArgumentException(ErrorMessage.LOTTONUMBER_OUT_OF_RANGE_MESSAGE.getMessage());
        }
    }

    public static void validateDuplicatedNumber(List<Integer> numbers, int number) {
        if (numbers.contains(number)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER_MESSAGE.getMessage());
        }
    }
}
