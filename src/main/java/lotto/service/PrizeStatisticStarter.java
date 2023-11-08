package lotto.service;

import java.util.EnumMap;
import java.util.Map;
import lotto.domain.Prize;

public class PrizeStatisticStarter {
    public static Map<Prize, Integer> initializePrizeStatistics() {
        Map<Prize, Integer> initialStatistics = new EnumMap<>(Prize.class);
        for (Prize prize : Prize.values()) {
            if (prize != Prize.NONE) {
                initialStatistics.put(prize, 0);
            }
        }
        return initialStatistics;
    }
}
