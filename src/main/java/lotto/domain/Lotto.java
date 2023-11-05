package lotto.domain;

import java.util.List;
import lotto.views.Exceptions;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateRange(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            Exceptions.exceptionNotNum6();
            throw new IllegalArgumentException();
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (var i=0; i<numbers.size(); i++) {
            if (numbers.get(i) < 1 || numbers.get(i) > 45) {
                Exceptions.exceptionNotRange();
                throw new IllegalArgumentException();
            }
        }
    }
}
