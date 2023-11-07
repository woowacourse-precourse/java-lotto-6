package lotto.model;

import lotto.model.enums.Rank;

import java.util.ArrayList;
import java.util.List;

public class LottoRankResult {
    private List<Integer> rankCount;

    public LottoRankResult() {
        this.rankCount = new ArrayList<>();
        for (int i = 0; i <= Rank.RANK5.getRank() ; i++) {
            rankCount.add(0);
        }
    }

    public void increaseRankCount(int rank) {
        if (rank != Rank.NO_RANK.getRank()) {
            int count = rankCount.get(rank);
            rankCount.set(rank, count + 1);
        }
    }

    public List<Integer> getRankResult() {
        int fromIndex = Rank.RANK1.getRank();
        int toIndex = Rank.RANK5.getRank() + 1;
        return rankCount.subList(fromIndex, toIndex);
    }

}
