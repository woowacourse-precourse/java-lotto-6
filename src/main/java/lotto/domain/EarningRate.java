package lotto.domain;

import java.util.List;

public class EarningRate {
    private long winningMoney = 0;

    public long calculateEarningRate(List<Integer> winningStatistics) {
        for (int i = 0; i < winningStatistics.size(); i++) {
            winningMoney += calEarning(winningStatistics.get(i));
        }

        return winningMoney;
    }

    private int calEarning(int count) {
        return EarningRateStatus.getValueByIndex(count);
    }
}
