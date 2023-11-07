package lotto.validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoValidator implements Validator<List<Integer>> {
    private final static int COUNT = 6;

    @Override
    public void validate(List<Integer> numbers) {
        if (!isLottoSize(numbers)) {
            Error error = Error.COUNT_ERROR;
            throw new IllegalArgumentException(error.message());
        }
        if (!areAllElementsDistinct(numbers)) {
            Error error = Error.DISTINCT_ERROR;
            throw new IllegalArgumentException(error.message());
        }
    }

    private boolean isLottoSize(List<Integer> numbers) {
        return numbers.size() == COUNT;
    }

    private boolean areAllElementsDistinct(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>();
        for (int number : numbers) {
            if (set.contains(number)) {
                return false;
            }
            set.add(number);
        }
        return true;
    }

    public boolean isSmallerThan(int input, int n) {
        return input < n;
    }
}
