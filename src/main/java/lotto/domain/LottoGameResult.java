package lotto.domain;

import lotto.constant.LottoRank;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static lotto.constant.NumericConstant.PROFIT_RATE_SCALE;


public class LottoGameResult {
    private Map<LottoRank, Integer> lottoResult = new HashMap<>();

    public LottoGameResult() {
        for (LottoRank lottoRank : LottoRank.values()) {
            lottoResult.put(lottoRank, 0);
        }
    }
    public void add(LottoRank lottoRank) {
        lottoResult.put(lottoRank, lottoResult.get(lottoRank) + 1);
    }

    public long getTotalReward() {
        long sum = 0;
        for (LottoRank rank : lottoResult.keySet()) {
            sum += rank.getRewardMoney() * lottoResult.get(rank);
        }

        return sum;
    }

    public double calculateProfitRate(int investAmount) {
        BigDecimal invest = new BigDecimal(investAmount);
        BigDecimal rewardMoney = new BigDecimal(getTotalReward());

        return rewardMoney.multiply(new BigDecimal(100))
                .divide(invest, PROFIT_RATE_SCALE, RoundingMode.HALF_UP)
                .doubleValue();
    }

    public int getNumberOfRank(LottoRank lottoRank) {
        return lottoResult.get(lottoRank);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        List<LottoRank> lottoRanks = new ArrayList<>(Arrays.asList(LottoRank.values()));
        lottoRanks.remove(LottoRank.NO_LUCK);
        Collections.reverse(lottoRanks);

        for (LottoRank lottoRank : lottoRanks) {
            result.append(lottoRank.toString());
            result.append(" - ");
            result.append(getNumberOfRank(lottoRank)+"개\n");
        }
        return result.toString();
    }
}
