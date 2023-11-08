package lotto.domain;

import lotto.constant.LottoRank;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

import static lotto.constant.NumericConstant.PROFIT_RATE_SCALE;


public class LottoGameResult {
    private long purchaseAmount;
    private Map<LottoRank, Integer> lottoResult = new HashMap<>(); // < 등수 , 인원수 >

    public LottoGameResult(long purchaseAmount) {
        for (LottoRank lottoRank : LottoRank.values()) {
            lottoResult.put(lottoRank, 0);
        }

        this.purchaseAmount = purchaseAmount;
    }

    public void add(LottoRank lottoRank) {
        lottoResult.put(lottoRank, lottoResult.get(lottoRank) + 1);
    }

    public double calculateProfitRate() {
        BigDecimal investAmount = new BigDecimal(purchaseAmount);
        BigDecimal rewardMoney = new BigDecimal(getTotalReward());

        return rewardMoney.multiply(new BigDecimal(100))
                .divide(investAmount, PROFIT_RATE_SCALE, RoundingMode.HALF_UP)
                .doubleValue();
    }

    private long getTotalReward() {
        long sum = 0;
        for (LottoRank rank : lottoResult.keySet()) {
            sum += rank.getRewardMoney() * lottoResult.get(rank);
        }

        return sum;
    }

    public int getCountOfRank(LottoRank lottoRank) {
        return lottoResult.get(lottoRank);
    }
}
