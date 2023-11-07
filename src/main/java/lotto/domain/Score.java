package lotto.domain;

import static lotto.global.LottoInformation.LOTTO_PRICE_UNIT;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Score {
    private static final int PERCENTAGE = 100;
    private final Map<LottoRank, Integer> lottoResult;

    public Score(final Map<LottoRank, Integer> lottoResult) {
        this.lottoResult = new HashMap<>(lottoResult);
    }

    public double getProfitRate() {
        int spent = 0;
        int gain = 0;
        for (LottoRank lottoRank : this.lottoResult.keySet()) {
            spent += getSpent(lottoRank);
            gain += getGain(lottoRank);
        }
        return getPercentage(spent, gain);
    }

    private static double getPercentage(final double spent, final double gain) {
        return (gain / spent) * PERCENTAGE;
    }

    private int getGain(final LottoRank lottoRank) {
        return this.lottoResult.get(lottoRank) * lottoRank.getPrizeMoney();
    }

    private int getSpent(final LottoRank lottoRank) {
        return this.lottoResult.get(lottoRank) * LOTTO_PRICE_UNIT;
    }

    public Map<LottoRank, Integer> getLottoResult() {
        return Collections.unmodifiableMap(this.lottoResult);
    }
}
