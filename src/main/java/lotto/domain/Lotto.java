package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.constant.ErrorMessage;
import lotto.constant.LottoNumber;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkRange(numbers);
        checkOverlap(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoNumber.SIZE.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.COUNT.getMessage());
        }
    }

    // TODO: 추가 기능 구현
    private void checkOverlap(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.OVERLAP.getMessage());
        }
    }

    private void checkRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            InputValidation.checkRange(number);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public int equalsNumberCount(Lotto lotto) {
        int count = 0;
        for (Integer number : numbers) {
            if (lotto.contains(number)) {
                ++count;
            }
        }
        return count;
    }
}
