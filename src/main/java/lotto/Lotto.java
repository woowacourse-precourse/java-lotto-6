package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = upperSort(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private List<Integer> upperSort(List<Integer> numbers) {
        return numbers.stream().sorted().toList();
    }

    @Override
    public String toString() {
        return "numbers =" + numbers;
    }
// TODO: 추가 기능 구현
}
