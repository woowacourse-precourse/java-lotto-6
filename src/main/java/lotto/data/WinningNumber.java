package lotto.data;

import java.util.ArrayList;
import java.util.List;

public class WinningNumber {
    private final List<Integer> numbers;
    private final int bonus;

    public WinningNumber(List<Integer> numbers, int bonus) {
        this.numbers = numbers;
        this.bonus = bonus;
    }

    public int getBonus() {
        return bonus;
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }
}
