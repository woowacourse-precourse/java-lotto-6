package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;
    // enum 으로 고칠 수 있으면 고쳐
    private final static int MIN_RANGE = 1;
    private final static int MAX_RANGE = 45;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        hasDuplicateNumber(numbers);
        validRange(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    private void hasDuplicateNumber(List<Integer> numbers) {
        Set<Integer> exceptDuplicateNumber = new HashSet<>(numbers);

        if (exceptDuplicateNumber.size() != numbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    private void validRange(List<Integer> numbers) {
        // stream 가능하면 바꿔
        for (int number : numbers) {
            if (!(number >= MIN_RANGE && number <= MAX_RANGE)) {
                throw new IllegalArgumentException();
            }
        }
    }
}
