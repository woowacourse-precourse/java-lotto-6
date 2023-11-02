package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        lottoSizeValidate(numbers);
        lottoNumberDuplicateValidate(numbers);
    }

    private void lottoSizeValidate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void lottoNumberDuplicateValidate(List<Integer> numbers) {
        Set<Integer> validate = new HashSet<>(numbers);

        if (validate.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
}
