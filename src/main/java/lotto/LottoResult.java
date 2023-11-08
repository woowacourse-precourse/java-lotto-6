package lotto;

import java.util.List;

public class LottoResult {
    private int count;
    private boolean bonus;
    public LottoResult(List<Integer> myLotto, Lotto lotto, int bonus) {
        this.count = setCount(myLotto, lotto);
        this.bonus = setBonus(myLotto, bonus);
    }

    private int setCount(List<Integer> myLotto, Lotto lotto) {
        return myLotto.stream().mapToInt(i -> {
            if (lotto.isInclude(i)) {
                return 1;
            }
            return 0;
        }).sum();
    }

    private boolean setBonus(List<Integer> myLotto, int bonus) {
        return myLotto.contains(bonus);
    }

    public int getCount() {
        return count;
    }

    public boolean getBonus() {
        return bonus;
    }
}
