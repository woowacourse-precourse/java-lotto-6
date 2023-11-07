package domain;

import constant.Rank;
import java.util.HashMap;

public class RankCount {
    private HashMap<Rank, Integer> rankCount;

    public RankCount() {
        initRankCount();
    }

    public HashMap<Rank, Integer> getRankCount() {
        return rankCount;
    }

    public void calculateRankCount(Lottos lottos, Lotto winningNumbers, BonusNumber bonusNumber) {
        for (Lotto lotto : lottos.getLottoList()) {
            Rank rank = lotto.getRank(winningNumbers.getNumbers(), bonusNumber.getBonusNumber());

            int currentCount = rankCount.getOrDefault(rank, 0);
            rankCount.put(rank, currentCount + 1);
        }
    }

    private void initRankCount() {
        rankCount = new HashMap<>();
        for (Rank rank : Rank.values()) {
            rankCount.put(rank, 0);
        }
    }
}
