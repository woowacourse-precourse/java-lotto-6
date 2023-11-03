package lotto.application;

import java.util.Map;
import lotto.domain.LottoResult;
import lotto.domain.Prize;

public class LottoStatistics {
    private final LottoResult lottoResult;
    private final int totalSpent;

    public LottoStatistics(LottoResult lottoResult, int totalSpent) {
        this.lottoResult = lottoResult;
        this.totalSpent = totalSpent;
    }

    public Map<Prize, Integer> getPrizeCount() {
        return lottoResult.getPrizeCount();
    }

    public double calculateTotalEarnings() {
        long totalEarnings = lottoResult.getPrizeCount().entrySet().stream()
                .mapToLong(prize -> (long) prize.getKey().getPrizeMoney() * prize.getValue())
                .sum();
        return totalEarnings;
    }

    public double calculateEarningsRate() {
        double totalEarnings = calculateTotalEarnings();
        return totalEarnings / totalSpent;
    }
}
