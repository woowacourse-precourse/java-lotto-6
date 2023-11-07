package lotto.object;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        duplicateValidate(numbers);
        OverUnderNumberValidate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현

    private void duplicateValidate(List<Integer> numbers) {
        if (numbers.stream().distinct().toArray().length != 6)
            throw new IllegalArgumentException();
    }

    private void OverUnderNumberValidate(List<Integer> numbers) {
        numbers.forEach((number) -> {
            if (number < 1 || number > 45)
                throw new IllegalArgumentException();

        });

    }

    List<Integer> getNumbers() {
        return numbers;
    }
}
