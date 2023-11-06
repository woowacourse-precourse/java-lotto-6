package lotto.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class Result {
    private Map<Rank, Integer> result;

    public Result() {
        result = new LinkedHashMap<>();

        for (Rank rank : Rank.values()) {
            result.put(rank, 0);
        }
    }

    public void updateResult(Rank rank) {
        int currentValue = result.get(rank);
        result.put(rank, currentValue + 1);
    }

    public String getResult() {
        StringBuilder output = new StringBuilder();
        for (Rank rank : result.keySet()) {
            if (rank != Rank.MISS) {
                output.append(rank.getMessage())
                        .append(" - ")
                        .append(result.get(rank))
                        .append("개\n");
            }
        }

        return output.toString();
    }
}
