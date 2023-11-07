package domain;

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
        for(int rankNumber = 1; rankNumber <= 5; rankNumber++){
            rankCount.put(rankNumber,Collections.frequency(rank,rankNumber));
        }
        return rankCount;
    }
}
