package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자가 아닙니다.");
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자 입니다.");
        }
    }
}
