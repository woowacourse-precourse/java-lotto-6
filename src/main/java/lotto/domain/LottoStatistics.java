package lotto.domain;

import java.util.Arrays;
import java.util.Map;
import lotto.global.constant.Winning;

public class LottoStatistics {

    private final Map<Winning, Integer> statistics;

    public LottoStatistics(Map<Winning, Integer> statistics) {
        this.statistics = statistics;
        Arrays.stream(Winning.values())
                .forEach(winning -> statistics.put(winning, 0));
    }

    public Map<Winning, Integer> getStatistics() {
        return statistics;
    }

}
