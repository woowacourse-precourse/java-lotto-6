package lotto;

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

    @Override
    public String toString() {
        return numbers.toString();
    }

    long countMatchingNumbers(Lotto winningLotto) {
        return winningLotto.numbers.stream()
                .filter(this.numbers::contains)
                .count();
    }

    boolean isInNumbers(int number) {
        return numbers.contains(number);
    }
}
