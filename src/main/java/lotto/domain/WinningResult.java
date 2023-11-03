package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningResult {
    Map<String, Integer> winningResult = new HashMap<>();

    public WinningResult(List<String> Rankings) {
        for(String Rank : Rankings) {
            winningResult.put(Rank, winningResult.getOrDefault(Rank, 0) + 1);
        }
    }

    public int getCount(String rank) {
        return winningResult.get(rank);
    }
}
