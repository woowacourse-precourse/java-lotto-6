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

    public double getProfitRatio(int price) {
        int totalProfit = getTotalProfit();
        return (double) Math.round((double) totalProfit * 10000 / price) / 100;
    }

    private int getTotalProfit() {
        int totalProfit = 0;
        for (LottoRank lottoRank : LottoRank.values()) {
            totalProfit += lottoRank.getPrize() * this.lottoResult.get(lottoRank);
        }
        return totalProfit;
    }

    public HashMap<LottoRank, Integer> getLottoResult() {
        return lottoResult;
    }
}
