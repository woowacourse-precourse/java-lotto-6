package lotto.domain;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);

        Collections.sort(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getLottoNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public int countMatch(Lotto winningLotto) {
        return (int) numbers.stream()
                .filter(winningLotto::containNumber)
                .count();
    }

    public boolean containNumber(int number) {
        return numbers.contains(number);
    }
}
