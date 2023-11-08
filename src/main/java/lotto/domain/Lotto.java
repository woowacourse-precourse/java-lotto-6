package lotto.domain;

import java.util.List;

import static lotto.Validator.*;
import static lotto.NumberConstants.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = List.copyOf(numbers);
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers, MIN_NUMBER, MAX_NUMBER);
        validateDuplicates(numbers);
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public int countMatches(Lotto lotto) {
        return (int) getNumbers().stream()
                .filter(number -> lotto.getNumbers().contains(number))
                .count();
    }

    public boolean matchWithBonus(int number) {
        return getNumbers().contains(number);
    }
}
