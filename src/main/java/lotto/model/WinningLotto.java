package lotto.model;

import lotto.consts.Constants;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningLotto {
    private final List<Integer> lotto;
    private final int bonus;

    public WinningLotto(List<Integer> lotto, int bonus) {
        validateLotto(lotto);
        validateBonus(lotto, bonus);
        this.lotto = lotto;
        this.bonus = bonus;
    }

    private void validateLotto(List<Integer> lotto) {
        Set<Integer> tempLotto = new HashSet<>(lotto);
        if(tempLotto.size() != Constants.COUNT_NO_BONUS) {
            throw new IllegalArgumentException();
        }
    }

    private void validateBonus(List<Integer> lotto, int bonus) {
        Set<Integer> tempLotto = new HashSet<>(lotto);
        tempLotto.add(bonus);
        if(tempLotto.size() != Constants.COUNT_WITH_BONUS) {
            throw new IllegalArgumentException();
        }
    }

    public int getBonus() {
        return bonus;
    }

    public List<Integer> getLotto() {
        return lotto;
    }
}
