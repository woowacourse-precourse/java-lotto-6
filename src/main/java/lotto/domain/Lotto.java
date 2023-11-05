package lotto.domain;

import java.util.List;

import static lotto.domain.Constant.MAX_LOTTOES_SIZE;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != MAX_LOTTOES_SIZE) {
            throw new IllegalArgumentException();
        }
    }

}
