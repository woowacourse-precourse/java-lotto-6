package lotto;

import java.util.Map;
import java.util.HashMap;

public class WinningResult {
    private final Map<Rank, Integer> result = new HashMap<>();

    public void addWinningTicket(int matchCount, boolean matchBonus) {
        Rank rank = Rank.valueOf(matchCount, matchBonus);
        result.put(rank, result.getOrDefault(rank, 0) + 1);
    }
}
