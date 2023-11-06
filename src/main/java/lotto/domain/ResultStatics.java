package lotto.domain;

import static lotto.domain.LottoPrice.LOTTO_UNIT_PRICE;

import java.util.Map;

public class ResultStatics {
    private final Map<LottoPrizeStatus, Integer> prizeResult;
    private final int issueMoney;
    private final double earningRate;

    public ResultStatics(Map<LottoPrizeStatus, Integer> prizeResult, int issueCount) {
        this.prizeResult = prizeResult;
        this.issueMoney = issueCount * LOTTO_UNIT_PRICE;
        this.earningRate = calculateEarningRate(prizeResult, issueMoney);
    }

    private double calculateEarningRate(Map<LottoPrizeStatus, Integer> prizeResult, int issueMoney) {
        long totalEarning = 0;
        for (LottoPrizeStatus status : prizeResult.keySet()) {
            int prizeCount = prizeResult.get(status).intValue();
            totalEarning += status.getPrizeMoney() * prizeCount;
        }
        return ((double)totalEarning / issueMoney) * 100;
    }

    public Map<LottoPrizeStatus, Integer> getPrizeResult() {
        return prizeResult;
    }

    public double getEarningRate() {
        return earningRate;
    }
}
