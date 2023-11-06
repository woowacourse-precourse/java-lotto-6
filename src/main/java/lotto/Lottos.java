package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int size() {
        return lottos.size();
    }

    public Lotto getIndexLotto(int index) {
        return lottos.get(index);
    }

    public Map<Integer, Integer> countMatches(Lotto winningLotto, int bonusNumber) {
        Map<Integer, Integer> rankCounts = new HashMap<>();
        for (int i = 0; i < 6; i++) {
            rankCounts.put(i, 0);
        }

        for (Lotto lotto : lottos) {
            int rank = CountWinningRanks(lotto.countMatchWithWinningLotto(winningLotto));
            if (rank == 2 && lotto.contains(bonusNumber)) {
                rank = 3;
            }
            rankCounts.put(rank, rankCounts.get(rank) + 1);
        }
        return rankCounts;
    }

    private static int CountWinningRanks(int matchesCount) {
        if (matchesCount == 6) {
            return 1;
        }
        if (matchesCount == 5) {
            return 2;
        }
        if (matchesCount == 4) {
            return 4;
        }
        if (matchesCount == 3) {
            return 5;
        }
        return 0;
    }

}
