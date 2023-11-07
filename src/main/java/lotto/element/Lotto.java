package lotto.element;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        Collections.sort(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    int countMatch(Lotto other) {
        List<Integer> otherNumbers = new List<>(other.getLottoNumbers());
        otherNumbers.retainAll(numbers);
        return otherNumbers.size();
    }
}
