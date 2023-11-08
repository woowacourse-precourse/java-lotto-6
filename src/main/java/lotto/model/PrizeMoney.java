package lotto.model;

import java.util.HashMap;
import java.util.Map;

public class PrizeMoney {

    private final Map<MatchResult, Integer> prizeInformation;

    public PrizeMoney() {
        prizeInformation = new HashMap<>();
        initializePrizeMoney();
    }

    private void initializePrizeMoney() {
        prizeInformation.put(new MatchResult(3, false), 5_000);
        prizeInformation.put(new MatchResult(4, false), 50_000);
        prizeInformation.put(new MatchResult(5, false), 1_500_000);
        prizeInformation.put(new MatchResult(5, true), 30_000_000);
        prizeInformation.put(new MatchResult(6, false), 2_000_000_000);
    }
}
