package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class Rank {

    Map<Integer, Integer> rankCount = new HashMap<>();

    public Rank() {
        rankCount.put(1, 0);
        rankCount.put(2, 0);
        rankCount.put(3, 0);
        rankCount.put(4, 0);
        rankCount.put(5, 0);
    }

    public void addRank(int rank) throws IllegalArgumentException {
        Integer count = rankCount.get(rank);
        if (count != null) {
            rankCount.put(rank, count + 1);
        }
        if (count == null) {
            throw new IllegalArgumentException();
        }
    }

    public int getRank(int rank) throws IllegalArgumentException {
        Integer count = rankCount.get(rank);
        if (count != null) {
            return count;
        }
        throw new IllegalArgumentException();
    }
}
