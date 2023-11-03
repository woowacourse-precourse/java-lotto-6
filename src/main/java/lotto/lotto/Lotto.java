package lotto.lotto;

import java.util.List;
import java.util.stream.Stream;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateSize(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    private int validateSize(List<Integer> numbers) {
        return (int) numbers.stream().distinct().count();
    }

    public Stream<Integer> streamNumbers() {
        return numbers.stream();
    }

}
