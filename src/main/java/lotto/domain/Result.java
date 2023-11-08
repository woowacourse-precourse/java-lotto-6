package lotto.domain;

import java.util.Map;

public class Result {
    private final Map<Policy, Integer> results;

    public Result(Map<Policy, Integer> results) {
        for (Policy rank : Policy.values()) {
            results.put(rank, 0);
        }
        this.results = results;
    }

    public Map<Policy, Integer> getResults() {
        return results;
    }
}