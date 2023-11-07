package domain;

import static util.LottoRankNumber.FIFTH;
import static util.LottoRankNumber.FIRST;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Rank {
    private List<Integer> rank;

    public Rank(List<Integer> rank){
        this.rank = rank;
    }

    public Map<Integer, Integer> count() {
        Map<Integer, Integer> rankCount = new HashMap<>();
        for(int rankNumber = FIRST.get(); rankNumber <= FIFTH.get(); rankNumber++){
            rankCount.put(rankNumber,Collections.frequency(rank,rankNumber));
        }
        return rankCount;
    }
}
