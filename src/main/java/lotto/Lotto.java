package lotto;

import java.util.List;
import lotto.exception.DuplicateNumberException;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public Lotto(LottoNumbers lottoNumbers) {
        List<Integer> numbers = lottoNumbers.convertToIntegerList();
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }

        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new DuplicateNumberException();
        }
    }
}
