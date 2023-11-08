package lotto.domain.lottery;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.FinalGrade;
import lotto.domain.Rank;

public class PlayerLotto {
    private final List<Lotto> lottos;

    public PlayerLotto(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public FinalGrade calculateFinalGrade(final WinningInformation winningInformation) {
        List<Rank> results = new ArrayList<>();
        for (Lotto lotto : lottos) {
            int containCounts = lotto.countMatchingNumbers(winningInformation.getWinningNumbers());
            boolean isMatchBonus = lotto.isContains(winningInformation.getBonusNumber());

            Rank rank = Rank.calculateRank(containCounts, isMatchBonus);
            results.add(rank);
        }
        return new FinalGrade(results);
    }

    @Override
    public String toString() {
        return String.valueOf(" playerLottos: " + lottos);
    }
}
