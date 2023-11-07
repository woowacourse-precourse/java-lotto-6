package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoRankResult {
    private List<Integer> rankCount;

    public LottoRankResult() {
        this.rankCount = new ArrayList<>();
        for (int i = 0; i < 6 ; i++) {
            rankCount.add(0);
        }
    }

    public void increaseRankCount(int rank) {
        if (rank != -1) {
            int count = rankCount.get(rank);
            rankCount.set(rank, count + 1);
        }
    }

    public List<Integer> getRankResult() {
        return Collections.unmodifiableList(rankCount);
    }
}
