package lotto.model;

import java.util.List;

public class Winning {
    private final List<Integer> numbers;
    private final int bonus;

    public Winning(List<Integer> numbers, int bonus) {
        checkWinningNumberLength(numbers);
        this.numbers = numbers;
        this.bonus = bonus;
    }

    private void checkWinningNumberLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
}
