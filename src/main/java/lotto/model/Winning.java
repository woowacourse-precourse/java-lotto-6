package lotto.model;

import java.util.List;

public class Winning {
    private final List<Integer> numbers;
    private final int bonus;

    private static final int start = 1;
    private static final int end = 45;

    public Winning(List<Integer> numbers, int bonus) {
        checkNumberLength(numbers);
        checkNumberRange(numbers);
        checkBonusRange(bonus);
        this.numbers = numbers;
        this.bonus = bonus;
    }

    private void checkNumberLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void checkNumberRange(List<Integer> numbers) {
        for (int number : numbers) {
            checkRange(number);
        }
    }

    private void checkBonusRange(int bonus) {
        checkRange(bonus);
    }

    private void checkRange(int num) {
        if ((num < start) || (num > end)) {
            throw new IllegalArgumentException();
        }
    }

}
