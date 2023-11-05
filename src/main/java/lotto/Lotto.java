package lotto;

import java.util.HashSet;
import java.util.List;
import lotto.validator.Validator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream().sorted().toList();
    }

    private void validate(List<Integer> numbers) {
        Validator.validateLottoNumber(numbers);
    }

    public boolean equals(Lotto lotto) {
        HashSet<Integer> lottoNumbers = new HashSet<>(this.numbers);
        return lottoNumbers.containsAll(lotto.numbers);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
