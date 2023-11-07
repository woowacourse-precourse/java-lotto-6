package lotto.domain;

import java.util.List;

public class Lotto extends LottoRule{
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (isInvalidLength(numbers)) {
            throw new IllegalArgumentException();
        }
        if (isDuplicate(numbers)){
            throw new IllegalArgumentException();
        }
        if (isOutOfRange(numbers)){
            throw new IllegalArgumentException();
        }
    }

}
