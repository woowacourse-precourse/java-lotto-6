package lotto.domain;

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
        isInRangeLottoNumbers(numbers);
        isCorrectSizeLottoNumbers(numbers);
        isNoDuplicateLottoNumbers(numbers);
    }

    public void isInRangeLottoNumbers(List<Integer> numbers) {
        for (int num : numbers) {
            if (num > 45 || num < 1) {
                throw new IllegalArgumentException();
            }
        }
    }

    public void isCorrectSizeLottoNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public void isNoDuplicateLottoNumbers(List<Integer> numbers) {
        Set<Integer> numbersSet = new HashSet<>(numbers);
        if (numbersSet.size() != numbers.size()) {
            throw new IllegalArgumentException();
        }
    }

}
