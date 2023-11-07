package lotto.model;

import java.util.List;

public class Bonus {
    private final Integer bonus;

    public Bonus(Integer bonus) {
        this.bonus = bonus;
    }

    public boolean checkMatchEachLotto(List<Integer> eachLotto) {
        return eachLotto.contains(bonus);
    }

}
