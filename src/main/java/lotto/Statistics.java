package lotto;

import java.util.HashMap;
import java.util.Map;

public class Statistics {

    private static Statistics statistics;
    private Map<Integer, Integer> winningNumberMatchCount;
    private Map<Integer, Integer> priceByMatchCount;

    private Statistics() {
        winningNumberMatchCount = new HashMap<>();

        winningNumberMatchCount.put(3, 0);
        winningNumberMatchCount.put(4, 0);
        winningNumberMatchCount.put(5, 0);
        winningNumberMatchCount.put(51, 0);
        winningNumberMatchCount.put(6, 0);

        priceByMatchCount = new HashMap<>();

        priceByMatchCount.put(3, 5000);
        priceByMatchCount.put(4, 50000);
        priceByMatchCount.put(5, 1500000);
        priceByMatchCount.put(51, 30000000);
        priceByMatchCount.put(6, 2000000000);

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
        return this.winningNumberMatchCount;
    }

    public Map<Integer, Integer> getPriceByMatchCount() {
        return this.priceByMatchCount;
    }
}
