package lotto;

import java.util.List;

public class WinningLotto {
    private final List<Integer> numbers;
    private final int bonus;

    public WinningLotto(List<Integer> numbers, int bonus) {
        validate(numbers);
        validateBonus(bonus);
        this.numbers = numbers;
        this.bonus = bonus;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        if (numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException();
        }
        if (numbers.stream().anyMatch(number -> number<1 || number>45)) {
            throw new IllegalArgumentException();
        }
    }

    private void validateBonus(int bonus) {
        if (bonus<1||bonus>45) {
            throw new IllegalArgumentException();
        }
    }
}
