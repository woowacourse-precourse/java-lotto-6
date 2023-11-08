package lotto.validator;

import lotto.constants.ValidationConstants;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoNumbersValidator {
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    private LottoNumbersValidator() {
    }

    public static void validateLotto(final List<Integer> numbers) {
        validateCountOfLottoNumbers(numbers);
        for (int number : numbers) {
            validateRangeOfEachNumber(number);
        }
        validateUniquenessOfNumbers(numbers);
    }

    public static void validateBonus(final List<Integer> numbers, final int bonusNumber) {
        List<Integer> allNumbers = new ArrayList<>(numbers);
        allNumbers.add(bonusNumber);
        validateUniquenessOfNumbers(allNumbers);
    }

    private static void validateCountOfLottoNumbers(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ValidationConstants.ERROR_INVALID_LOTTO_NUMBER_COUNT.getMessage());
        }
    }

    private static void validateRangeOfEachNumber(int number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(ValidationConstants.ERROR_OUT_OF_RANGE_LOTTO_NUMBER.getMessage());
        }
    }

    public static void validateUniquenessOfNumbers(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(ValidationConstants.ERROR_DUPLICATE_LOTTO_NUMBER.getMessage());
        }
    }
}
