package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Lotto issue(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    public int countHitNumbers(Lotto comparisonTarget) {
        int hit = 0;
        for (int number: comparisonTarget.numbers) {
            if (this.numbers.contains(number))
                hit++;
        }
        return hit;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

}
