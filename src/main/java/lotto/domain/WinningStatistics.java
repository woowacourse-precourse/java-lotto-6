package lotto.domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class WinningStatistics {

    private Map<Prize, Integer> statistics;

    public WinningStatistics() {
        statistics = new LinkedHashMap<>();
        initStatistics();
    }

    private void initStatistics() {
        Prize[] prizes = Prize.values();
        for (Prize prize : prizes) {
            statistics.put(prize, 0);
        }
    }


}
