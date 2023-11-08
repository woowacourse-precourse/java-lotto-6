package lotto.domain;

import lotto.constants.ErrorConstants;
import lotto.utils.ListUtil;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public boolean contains(int value) {
        return numbers.contains(value);
    }

    public int countMatches(List<Integer> winningList) {
        return (int) numbers.stream()
                .filter(winningList::contains)
                .count();
    }

    public List<Integer> getLotto() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (!ListUtil.checkDuplicateValue(numbers)) {
            throw new IllegalArgumentException(ErrorConstants.ERROR_LOTTO_DUPLICATED_VALUE.getData());
        }
        if (!ListUtil.checkLength(numbers)) {
            throw new IllegalArgumentException(ErrorConstants.ERROR_LOTTO_INVALID_LENGTH.getData());
        }
        if (!ListUtil.checkRange(numbers)) {
            throw new IllegalArgumentException(ErrorConstants.ERROR_LOTTO_INVALID_RANGE.getData());
        }
    }
}