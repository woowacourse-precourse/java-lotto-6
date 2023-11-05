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

    //FIXME: REFACTORING POINT
    public int countMatches(final Lotto otherLotto) {
        int count = 0;
        for (Integer number : numbers) {
            if (otherLotto.numbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    public boolean contains(BonusNumber bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
