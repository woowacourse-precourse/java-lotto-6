package lotto.Domain;

import java.util.HashMap;
import java.util.Map;
import lotto.Constant.Constant;
import lotto.Util.LottoComparator;

public class LottoResult {

    private Map<LottoRank, Integer> lottoResult;

    public LottoResult() {
        initLottoResult();
    }

    public void calculateLottoResult(Lotties lotties, Lotto userLotto, Bonus bonus) {
        for (Lotto lotto : lotties.getLotties()) {
            int matchCount = LottoComparator.getMatchCount(lotto, userLotto);
            boolean matchBonus = false;
            if (matchCount == Constant.LOTTO_MIN_MATCH_COUNT) {
                matchBonus = LottoComparator.getMatchBonus(lotto, bonus);
            }
            LottoRank lottoRank = LottoRank.getLottoRank(matchCount, matchBonus);
            lottoResult.put(lottoRank, lottoResult.getOrDefault(lottoRank, 0) + 1);
        }
    }

    public double getRate(long money) {
        return ((double) sumPrice() / money) * 100;
    }

    public long sumPrice() {
        long sum = 0;
        for (LottoRank rank : lottoResult.keySet()) {
            Integer count = lottoResult.get(rank);
            if (count > 0) {
                sum += rank.getPrice();
            }
        }
        return sum;
    }

    private void initLottoResult() {
        lottoResult = new HashMap<>();
        for (LottoRank lottoRank : LottoRank.values()) {
            lottoResult.put(lottoRank, 0);
        }
    }

    public Map<LottoRank, Integer> getLottoResult() {
        return lottoResult;
    }
}
