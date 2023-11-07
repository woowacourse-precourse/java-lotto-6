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
