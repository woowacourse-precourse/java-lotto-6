package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class PlayerLotto {
    private final List<Lotto> lottos;

    public PlayerLotto(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public FinalGrade calculateFinalGrade(final Lotto winningNumber, final LottoNumber bonusNumber) {
        List<Rank> results = new ArrayList<>();
        for (Lotto lotto : lottos) {
            int containCounts = lotto.countMatchingNumbers(winningNumber);
            boolean isMatchBonus = lotto.isContains(bonusNumber);

            Rank rank = Rank.calculateRank(containCounts, isMatchBonus);
            results.add(rank);
        }
        return new FinalGrade(results);
    }
}
