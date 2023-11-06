package lotto.model;

import java.util.Arrays;

public class WinnerLotto {
    Lotto WinnerLotto;
    int bonus;

    public WinnerLotto(Lotto winnerLotto, int bonus) {
        this.WinnerLotto = winnerLotto;
        this.bonus = bonus;
    }

    public Rank compare(Lotto lotto) {
        int count = getMatchCount(lotto);
        boolean bonus = lotto.contains(this.bonus);
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.calculateRank(count, bonus))
                .findFirst()
                .orElse(Rank.NONE);
    }

    private int getMatchCount(Lotto lotto) {
        return (int) lotto.getNumbers()
                .stream()
                .filter(WinnerLotto::contains)
                .count();
    }
}

