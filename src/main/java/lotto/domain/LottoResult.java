package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    public Map<Rank, Integer> compareLotto(Lottos lottos, Lotto winningLotto, int bonusNumber) {
        Map<Rank, Integer> result = new HashMap<>();
        for (Lotto lotto : lottos.getLottos()) {
            int matchCount = getMatchCount(lotto, winningLotto);
            boolean matchBonus = lotto.getNumbers().contains(bonusNumber);

            Rank rank = determineRank(matchCount, matchBonus);

            result.put(rank, result.getOrDefault(rank, 0) + 1);
        }
        return result;
    }
    private Rank determineRank(int matchCount, boolean matchBonus) {
        for (Rank rank : Rank.values()) {
            if (rank.result(matchCount, matchBonus)) {
                return rank;
            }
        }
        return Rank.NONE;
    }

    private int getMatchCount(Lotto lotto, Lotto winningLotto) {
        return (int)lotto.getNumbers().stream()
                .filter(winningLotto.getNumbers()::contains)
                .count();
    }
}
