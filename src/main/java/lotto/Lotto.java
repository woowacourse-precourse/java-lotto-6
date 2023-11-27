package lotto;

import lotto.exception.LottoException;

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
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(String.valueOf(LottoException.INVALID_INPUT_SIZE));
        }

        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(String.valueOf(LottoException.INVALID_INPUT_NUMBER));
            }
        }

        Set<Integer> duplicateNumber = new HashSet<>(numbers);
        if (duplicateNumber.size() != numbers.size()) {
            throw new IllegalArgumentException(String.valueOf(LottoException.DUPLICATE_INPUT_NUMBER));
        }

        System.out.println(numbers);
    }
}
