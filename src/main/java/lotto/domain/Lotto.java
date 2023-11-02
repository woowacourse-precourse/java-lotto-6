package lotto.domain;

import java.util.Set;

public class Lotto {
    private final Set<Integer> numbers;

    public Lotto(Set<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(Set<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public String getLottoNumbers() {
        return numbers.toString();
    }
}
