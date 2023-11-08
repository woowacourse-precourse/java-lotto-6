package lotto.support;

import lotto.domain.Lotto;

public class LottoComparator {

    private final Lotto winning;

    private final int bonus;

    public LottoComparator(Lotto winning, int bonus) {
        this.winning = winning;
        this.bonus = bonus;
    }

    public Rate compareLotto(Lotto lotto) {
        int count = 0;
        boolean bonus = false;
        for (int i = 0; i < winning.getLottoSize(); i++) {
            if (lotto.find(winning.get(i))) {
                count++;
            }
            if (lotto.get(i) == this.bonus) {
                bonus = true;
            }
        }

        return Rate.valueOf(count, bonus);
    }


}
