package lotto.model;


import lotto.util.Validator;

import java.util.ArrayList;
import java.util.List;

public class WinningNumbers {
    private final List<Integer> numbers;
    private final int bonus;

    private WinningNumbers(List<Integer> numbers, int bonus) {
        this.numbers = numbers;
        this.bonus = bonus;
    }

    public static WinningNumbers of(List<Integer> numbers, int bonus) {
        Validator.validateWinningNumbers(numbers);
        Validator.validateBonusNumber(numbers,bonus);
        return new WinningNumbers(numbers, bonus);
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }

    public int getBonus() {
        return bonus;
    }
}
