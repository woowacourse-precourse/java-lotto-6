package lotto.lotto;

import java.util.List;

public class AnswerLotto extends Lotto{
    private int bonus;

    public AnswerLotto(List<Integer> numbers, Integer bonus) {
        super(numbers);
        this.bonus = bonus;
    }

    public int getBonus() {
        return this.bonus;
    }
}
