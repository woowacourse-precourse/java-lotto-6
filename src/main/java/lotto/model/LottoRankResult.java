package lotto.model;

import lotto.model.enums.PrizeInfo;

import java.util.ArrayList;
import java.util.List;

public class LottoRankResult {
    private List<Integer> rankCount;

    public LottoRankResult() {
        this.rankCount = new ArrayList<>();
        for (int i = 0; i <= PrizeInfo.values().length; i++) {
            rankCount.add(0);
        }
    }

    public void increaseRankCount(int rank) {
        int count = rankCount.get(rank);
        rankCount.set(rank, count + 1);
    }

    public int getCount(int rank) {
        return rankCount.get(rank);
    }
}
