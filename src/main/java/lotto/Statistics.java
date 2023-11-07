package lotto;

import java.util.HashMap;
import java.util.Map;

public class Statistics {

    private static Statistics statistics;
    private Map<Integer, Integer> winningNumberMatchCount;

    private Statistics() {
        winningNumberMatchCount = new HashMap<>();

        winningNumberMatchCount.put(3, 0);
        winningNumberMatchCount.put(4, 0);
        winningNumberMatchCount.put(5, 0);
        winningNumberMatchCount.put(51, 0);
        winningNumberMatchCount.put(6, 0);
    }
    public static Statistics getInstance() {
        if ( statistics == null ) {
            statistics = new Statistics();
        }
        return statistics;
    }

    public void integrate(int winningCount, int bonusCount) {

        int joinWinBonus = Integer.parseInt(Integer.toString(winningCount) + Integer.toString(bonusCount));

        if ( winningNumberMatchCount.containsKey(joinWinBonus) ) {
            int oldValue = winningNumberMatchCount.get(joinWinBonus);
            winningNumberMatchCount.put(joinWinBonus, oldValue + 1);
        }

        if ( !winningNumberMatchCount.containsKey(joinWinBonus) &&
                winningNumberMatchCount.containsKey(winningCount) ) {

            int oldValue = winningNumberMatchCount.get(winningCount);
            winningNumberMatchCount.put(winningCount, oldValue + 1);
        }
    }

    public Map<Integer, Integer> getWinningNumberMatchCount() {
        return winningNumberMatchCount;
    }
}
