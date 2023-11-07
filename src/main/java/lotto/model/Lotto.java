package lotto.model;

import static lotto.constant.Numbers.NUMBERSPERLOTTO;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateDuplicatedNumbers(numbers);
        validateListSize(numbers);
    }

    // TODO: 추가 기능 구현
    public List<Integer> getLotto() {
        return numbers;
    }

    private void validateDuplicatedNumbers(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateListSize(List<Integer> numbers) {
        if (numbers.size() != NUMBERSPERLOTTO.getIntValue()) {
            throw new IllegalArgumentException();
        }
    }
}
