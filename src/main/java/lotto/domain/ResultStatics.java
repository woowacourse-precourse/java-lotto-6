package lotto.domain;

import static lotto.domain.LottoPrice.UNIT_PRICE;

import java.util.Map;

public class ResultStatics {
    private final Map<LottoPrizeStatus, Integer> resultMap;
    private final int issueMoney;
    private final double earningRate;

    public ResultStatics(Map<LottoPrizeStatus, Integer> resultMap, int issueCount) {
        this.resultMap = resultMap;
        this.issueMoney = issueCount * UNIT_PRICE;
        this.earningRate = calculateEarningRate(resultMap, issueMoney);

    }

    private double calculateEarningRate(Map<LottoPrizeStatus, Integer> resultMap, int issueMoney) {
        long totalEarning = 0;
        for (LottoPrizeStatus status : resultMap.keySet()) {
            totalEarning += status.getPrizeMoney() * resultMap.get(status);
        }
        return (double)totalEarning / issueMoney;
    }

    public Map<LottoPrizeStatus, Integer> getResultMap() {
        return resultMap;
    }
}
