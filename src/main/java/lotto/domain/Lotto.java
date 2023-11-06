package lotto.domain;

import java.util.List;
import java.util.Set;

public class Lotto {

    private static final int ALLOWED_NUMBER_SIZE = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (!isAllowedNumberSize(numbers) || !isUniqueNumbers(numbers)) {
            throw new IllegalArgumentException("유효하지 않은 로또 번호입니다.");
        }
    }

    private boolean isAllowedNumberSize(List<Integer> numbers) {
        return numbers.size() == ALLOWED_NUMBER_SIZE;
    }

    private boolean isUniqueNumbers(List<Integer> numbers) {
        return Set.copyOf(numbers)
                .size() == ALLOWED_NUMBER_SIZE;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
