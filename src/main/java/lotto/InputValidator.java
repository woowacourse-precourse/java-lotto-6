package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {
    private static final String ERROR_LOTTO_SIZE = "[ERROR] 로또는 6개의 숫자로 이루어져야 합니다.";
    private static final String ERROR_NUMBER_RANGE = "[ERROR] 로또 숫자는 1부터 45 사이어야 합니다.";
    private static final String ERROR_DUPLICATE_NUMBERS = "[ERROR] 로또 숫자에 중복된 숫자가 있습니다.";

    public void validateLottoNumbers(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDuplicates(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != Lotto.LOTTO_SIZE) {
            throw new IllegalArgumentException(ERROR_LOTTO_SIZE);
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < Lotto.MIN_NUMBER || number > Lotto.MAX_NUMBER) {
                throw new IllegalArgumentException(ERROR_NUMBER_RANGE);
            }
        }
    }

    private void validateDuplicates(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != Lotto.LOTTO_SIZE) {
            throw new IllegalArgumentException(ERROR_DUPLICATE_NUMBERS);
        }
    }
}
