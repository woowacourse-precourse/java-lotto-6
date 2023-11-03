package lotto;

import static lotto.IntConstants.MAX_RANGE;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        checkLottoNumbersCount(numbers);
        isDuplicated(numbers);
        isProperRange(numbers);
    }

    private void checkLottoNumbersCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_SIZE_MESSAGE.getMessage());
        }
    }

    private void isDuplicated(List<Integer> numbers) {
        int originalSize = numbers.size();
        Set<Integer> set = new HashSet<>(numbers);

        if (originalSize != set.size()) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_DUPLICATED_NUMBER_MESSAGE.getMessage());
        }
    }

    private void isProperRange(List<Integer> numbers) {
        List<Integer> filteredNumbers = numbers.stream()
                .filter(num -> num >= IntConstants.MIN_RANGE.getValue()
                        && num <= MAX_RANGE.getValue())
                .toList();

        if (filteredNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_RANGE_MESSAGE.getMessage());
        }
    }
}
