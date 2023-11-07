package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    private Lotto(List<Integer> numbers) {
        validate();
        this.numbers = numbers;
    }

    public static Lotto from(List<Integer> lottoNumbers) {
        return new Lotto(lottoNumbers);
    }

    public void validate() {
        validateNumberOfNumber(numbers);
    }

    private void validateNumberOfNumber(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
}

