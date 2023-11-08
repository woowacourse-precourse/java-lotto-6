package lotto;

import java.util.List;

public class WinningLotto extends Lotto {
    private final Integer bonus;

    public WinningLotto(List<Integer> numbers, Integer bonus) {
        super(numbers);
        this.bonus = bonus;
    }

    public Integer getBonus() {
        return bonus;
    }
}
