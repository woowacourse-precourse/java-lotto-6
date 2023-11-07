package lotto.model;

import java.util.List;

public class WinningLotto extends Lotto {
    private int bonus;

    public WinningLotto(List<Integer> numbers, int bonus) {
        super(numbers);
        this.bonus = bonus;
    }

    public int getBonus() {
        return bonus;
    }

}
