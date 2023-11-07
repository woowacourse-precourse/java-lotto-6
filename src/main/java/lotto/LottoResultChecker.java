package lotto;

import java.util.HashMap;
import java.util.List;

public class LottoResultChecker {
    HashMap<LottoRank, Integer> lottoResult;

    public LottoResultChecker() {
        this.lottoResult = new HashMap<>();
        for (LottoRank lottoRank : LottoRank.values()) {
            this.lottoResult.put(lottoRank, 0);
        }
    }

    public void checkLotto(List<Lotto> lottos, WinningLotto drawnNumbers) {
        for (Lotto lotto : lottos) {
            LottoRank rank = LottoRank.getRank(lotto, drawnNumbers);
            if (null != rank) {
                Integer count = this.lottoResult.get(rank);
                this.lottoResult.put(rank, count + 1);
            }
        }
    }

    public void printTotalPrize() {
    }

    public void printProfit() {
    }
}
