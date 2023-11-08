package domain;

import java.util.Arrays;

public class WinningLotto {
    private final Lotto winningLotto;
    private final int bonus;


    public WinningLotto(Lotto lotto, int bonus) {
        winningLotto = lotto;
        this.bonus = bonus;
    }

    public Rank calculateRank(Lotto lotto) {
        int matchCount = getMatchCount(lotto);
        boolean hasBonus = lotto.contains(this.bonus);
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.win(matchCount, hasBonus))
                .findFirst()
                .orElse(Rank.MISS);
    }

    private int getMatchCount(Lotto lotto) {
        return (int) lotto.cloneNumbers()
                .stream()
                .filter(winningLotto::contains)
                .count();
    }

}
