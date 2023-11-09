package lotto.validator;

import static lotto.constants.LottoConstants.LOTTO_TOTAL_NUMBERS;
import static lotto.constants.LottoConstants.MAX_NUMBER;
import static lotto.constants.LottoConstants.MIN_NUMBER;
import static lotto.constants.ValidationConstants.ERROR_DUPLICATE_LOTTO_NUMBER;
import static lotto.constants.ValidationConstants.ERROR_INVALID_LOTTO_NUMBER_COUNT;
import static lotto.constants.ValidationConstants.ERROR_OUT_OF_RANGE_LOTTO_NUMBER;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoNumbersValidator {
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
        if (numbers.size() != LOTTO_TOTAL_NUMBERS) {
            throw new IllegalArgumentException(ERROR_INVALID_LOTTO_NUMBER_COUNT.getMessage());
        }
    }

    private static void validateRangeOfEachNumber(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(ERROR_OUT_OF_RANGE_LOTTO_NUMBER.getMessage());
        }
    }

    public static void validateUniquenessOfNumbers(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(ERROR_DUPLICATE_LOTTO_NUMBER.getMessage());
        }
    }
}
