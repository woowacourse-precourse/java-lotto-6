package lotto.model;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }

        List<Integer> checking = numbers.stream().distinct().toList();
        if (numbers.size() != checking.size()) {
            throw new IllegalArgumentException();
        }

        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException();
            }
        }
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return numbers;
    }
}
