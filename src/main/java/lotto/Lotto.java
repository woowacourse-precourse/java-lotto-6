package lotto;

import java.util.List;
import java.util.Set;

public class Lotto {
    private static final int LOTTO_NUMBERS_SIZE = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (isaInvalidLength(numbers) || isDuplicated(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isaInvalidLength(List<Integer> numbers) {
        return numbers.size() != LOTTO_NUMBERS_SIZE;
    }

    private boolean isDuplicated(List<Integer> numbers) {
        if(Set.copyOf(numbers).size() != numbers.size()) {
            return true;
        }
        return false;
    }

    // TODO: 추가 기능 구현
}
