package lotto.domain;

import java.util.Arrays;
import java.util.HashMap;

public class NumberOfRanks {

    private final HashMap<Rank, Integer> numberOfRanks = new HashMap<>();

    private NumberOfRanks() {
        Arrays.stream(Rank.values()).forEach(rank -> numberOfRanks.put(rank, 0));
    }

    public static NumberOfRanks count() {
        return new NumberOfRanks();
    }

    public void addRank(Rank rank) {
        int number = numberOfRanks.getOrDefault(rank, 0) + 1;
        numberOfRanks.put(rank, number);
    }

    public int getRankCount(Rank rank) {
        return numberOfRanks.get(rank);
    }
}
