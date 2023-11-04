package lotto.lotto;

import java.util.List;
import java.util.stream.IntStream;

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
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int compare(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        return (int) IntStream.range(0, 6)
                .filter(i -> this.numbers.get(i) == numbers.get(i))
                .count();
    }
}
