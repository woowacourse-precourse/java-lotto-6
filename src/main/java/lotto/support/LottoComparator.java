package lotto.support;

import lotto.domain.Lotto;

import java.util.List;

public class LottoComparator {

    private List<Integer> winning;

    private int bonus;

    public LottoComparator(List<Integer> winning, int bonus) {
        this.winning = winning;
        this.bonus = bonus;
    }

    public Rate compareLotto(Lotto lotto) {
        int count = 0;
        boolean bonus = false;
        for (int i = 0; i < winning.size(); i++) {
            if (lotto.find(winning.get(i))) {
                count++;
            }
            if (winning.get(i) == this.bonus) {
                bonus = true;
            }
        }

        return Rate.valueOf(count, bonus);
    }



}
