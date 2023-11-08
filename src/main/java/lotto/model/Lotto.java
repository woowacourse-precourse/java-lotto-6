package lotto.model;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplication(numbers);
        validateRange(1, 45, numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6자리이어야 합니다. 다시 입력해주세요.");
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        if (numbers.stream().distinct().collect(Collectors.toList()).size() != 6) {
            throw new IllegalArgumentException("[ERROR] 중복되는 값이 없어야합니다. 다시 입력해주세요.");
        }
    }

    private void validateRange(int start, int end, List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 범위가 벗어나는 값이 있으면 안됩니다(1<=값<=45). 다시 입력해주세요.");
            }
        }
    }
}