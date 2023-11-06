package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final String WRONG_SIZE_ERROR_MESSAGE = "6개의 정수를 입력해주세요.";
    private static final String OUT_OF_RANGE_ERROR_MESSAGE = "1 이상 45 이하의 정수를 입력해주세요.";
    private static final String DUPLICATE_NUMBERS_ERROR_MESSAGE = "서로 다른 정수를 입력해주세요.";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (!isSixNumbers(numbers)) {
            throw new IllegalArgumentException(WRONG_SIZE_ERROR_MESSAGE);
        } else if (!isInLottoRange(numbers)) {
            throw new IllegalArgumentException(OUT_OF_RANGE_ERROR_MESSAGE);
        } else if (hasDuplicateNumbers(numbers)) {
            throw new IllegalArgumentException(DUPLICATE_NUMBERS_ERROR_MESSAGE);
        }
    }

    private boolean isSixNumbers(final List<Integer> numbers) {
        return numbers.size() == 6;
    }

    private boolean isInLottoRange(final List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                return false;
            }
        }
        return true;
    }

    private boolean hasDuplicateNumbers(final List<Integer> numbers) {
        Set<Integer> numbersUnique = new HashSet<>(numbers);
        return numbersUnique.size() != numbers.size();
    }
}
