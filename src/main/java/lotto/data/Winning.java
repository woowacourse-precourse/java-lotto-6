package lotto.data;

import java.util.List;

public class Winning {
    private final List<Integer> numbers;
    private final int bonus;

    public Winning(List<Integer> numbers, int bonus) {
        validate(numbers);
        this.numbers = numbers;
        this.bonus = bonus;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public int match(Lotto lotto) {
        int matchCount = 0;
        for (Integer number : lotto.getNumbers()) {
            if (numbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    public boolean isBonusMatch(Lotto lotto) {
        return lotto.getNumbers().contains(bonus);
    }
}
