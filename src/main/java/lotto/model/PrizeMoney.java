package lotto.model;

import java.util.HashMap;
import java.util.Map;

public class PrizeMoney {

    private static final Map<MatchResult, Integer> PRIZE_MONEY = initializePrizeMoney();

    private static Map<MatchResult, Integer> initializePrizeMoney() {
        Map<MatchResult, Integer> prizeMoney = new HashMap<>();
        prizeMoney.put(new MatchResult(3, false), 5_000);
        prizeMoney.put(new MatchResult(4, false), 50_000);
        prizeMoney.put(new MatchResult(5, false), 1_500_000);
        prizeMoney.put(new MatchResult(5, true), 30_000_000);
        prizeMoney.put(new MatchResult(6, false), 2_000_000_000);
        return prizeMoney;
    }

    public static Map<MatchResult, Integer> getPrizeMoney() {
        return PRIZE_MONEY;
    }
}
