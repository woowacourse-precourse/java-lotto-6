package lotto;

import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private Map<LottoRank, Integer> rankResult = new EnumMap<LottoRank, Integer>(LottoRank.class);

    public LottoResult(List<Lotto> lottery, WinningLotto winningLotto) {
        for (LottoRank lottoRank : LottoRank.values()) {
            rankResult.put(lottoRank, 0);
        }
        checkLottery(lottery, winningLotto);
    }

    private void checkLottery(List<Lotto> lottery, WinningLotto winningLotto) {
        for (Lotto lotto : lottery) {
            LottoRank lottoRank = winningLotto.makeRank(lotto);
            rankResult.put(lottoRank, rankResult.get(lottoRank) + 1);
        }
    }

    public Map<LottoRank, Integer> getRankResult() {
        return Collections.unmodifiableMap(rankResult);
    }

    public int countPurchases() {
        int count = 0;
        for (int value : rankResult.values()) {
            count += value;
        }
        return count;
    }
}
