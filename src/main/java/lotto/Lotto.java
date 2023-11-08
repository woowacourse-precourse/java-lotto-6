package lotto;

import java.util.List;
import java.util.stream.Collectors;
import lotto.exception.LottoRangeException;

public class Lotto {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        sizeValidate(numbers);
        rangeValidate(numbers);
    }

    private void sizeValidate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void rangeValidate(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new LottoRangeException();
        }
    }

    private void rangeValidate(List<Integer> numbers) {
        numbers.forEach(this::rangeValidate);
    }

    public List<Integer> sortLotto(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
