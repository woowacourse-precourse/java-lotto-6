package lotto.repository;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import lotto.model.Rank;

public class Result {

    private static final Map<Rank, Integer> result = new HashMap<>();

    public void init() {
        Arrays.stream(Rank.values()).forEach(rank -> result.put(rank, 0));
    }

    public void add(Rank rank) {
        int count = result.get(rank);
        result.put(rank, ++count);
    }

    public int get(Rank rank) {
        return result.get(rank);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(Rank.values())
                .forEach(rank -> sb.append(String.format(rank.getMessage(), result.get(rank))).append("\n"));
        return sb.toString();
    }
}
