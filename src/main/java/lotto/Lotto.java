package lotto;

import java.util.List;
import lotto.domain.BonusNumber;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public int countMatches(final Lotto winningLotto) {
        return Math.toIntExact(this.numbers.stream()
                .filter(winningLotto.numbers::contains)
                .count());
    }

    public boolean contains(BonusNumber bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
