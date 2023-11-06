package lotto.domain;

import java.util.Arrays;
import java.util.Map;
import lotto.global.constant.WinningType;

public class LottoStatistics {

    private final Map<WinningType, Integer> statistics;

    public LottoStatistics(Map<WinningType, Integer> statistics) {
        this.statistics = statistics;
        Arrays.stream(WinningType.values())
                .forEach(winningType -> statistics.put(winningType, 0));
    }

    public Map<WinningType, Integer> getStatistics() {
        return statistics;
    }

}
