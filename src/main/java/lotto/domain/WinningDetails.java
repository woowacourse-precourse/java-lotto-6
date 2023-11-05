package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class WinningDetails {

    private final Map<Rank, Integer> details;

    public WinningDetails() {
        this.details = new HashMap<>();
    }

    public void addRank(Rank rank) {
        details.put(rank, details.getOrDefault(rank, 0) + 1);
    }
}
