package lotto.service;

import static lotto.constant.Constant.ZERO;

import java.util.Map;
import lotto.constant.Rank;
import lotto.view.output.OutputView;

public class CalculateStatisticService {
    private final OutputView outputView;

    public CalculateStatisticService(OutputView outputView) {
        this.outputView = outputView;
    }

    public long calculatePrizeMoney(Map<Rank, Integer> statistics) {
        long totalPrizeMoney = ZERO;
        for (Rank rank : statistics.keySet()) {
            totalPrizeMoney += rank.prizeMoney * statistics.getOrDefault(rank, ZERO);
        }
        return totalPrizeMoney;
    }
}
