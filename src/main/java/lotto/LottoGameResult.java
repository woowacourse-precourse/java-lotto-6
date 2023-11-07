package lotto;

import lotto.constant.LottoRank;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class LottoGameResult {
    private Map<LottoRank, Integer> lottoResult = new HashMap<>();
    private long reward;

    public LottoGameResult() {
        for (LottoRank lottoRank : LottoRank.values()) {
            lottoResult.put(lottoRank, 0);
        }
    }
    public void add(LottoRank lottoRank) {
        lottoResult.put(lottoRank, lottoResult.get(lottoRank) + 1);
        reward += lottoRank.getRewardMoney();
    }

    public double calculateProfitRate(int originalMoney) {
        BigDecimal original = new BigDecimal(originalMoney);
        BigDecimal rewardMoney = new BigDecimal(reward);

        return rewardMoney.divide(original)
                .multiply(new BigDecimal(100))
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();
    }

    public int getNumberOfRank(LottoRank lottoRank) {
        return lottoResult.get(lottoRank);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        List<LottoRank> lottoRanks = new ArrayList<>(Arrays.asList(LottoRank.values()));
        lottoRanks.remove(LottoRank.ETC);
        Collections.reverse(lottoRanks);

        for (LottoRank lottoRank : lottoRanks) {
            result.append(lottoRank.toString());
            result.append(" - ");
            result.append(getNumberOfRank(lottoRank)+"개\n");
        }
        return result.toString();
    }
}
