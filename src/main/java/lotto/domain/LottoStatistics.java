package lotto.domain;

import java.util.Arrays;
import java.util.Map;
import lotto.global.constant.WinningType;

public class LottoStatistics {

    private final Map<WinningType, Long> statistics;

    public LottoStatistics(Map<WinningType, Long> statistics) {
        this.statistics = statistics;
        Arrays.stream(WinningType.values())
                .forEach(winningType -> statistics.put(winningType, 0L));
    }

    public Map<WinningType, Long> getStatistics() {
        return statistics;
    }

    public Long getTotalWinningMoney() {
        return statistics.values()
                .stream()
                .reduce(0L, Long::sum);
    }

}
