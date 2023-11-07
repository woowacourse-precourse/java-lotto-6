package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class Statistic {

    Map<Integer, Integer> rankCount = new HashMap<>();

    public Statistic() {
        rankCount.put(1, 0);
        rankCount.put(2, 0);
        rankCount.put(3, 0);
        rankCount.put(4, 0);
        rankCount.put(5, 0);
    }

    public void addRank(Integer rank) throws IllegalArgumentException {
        if (rank == null) {
            return;
        }
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
        if (count == null) {
            throw new IllegalArgumentException();
        }
        return count;
    }
}
