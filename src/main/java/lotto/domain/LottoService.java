package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoService {

    private static final int LOTTO_PRICE = 1000;

    public Map<LottoRank, Integer> getWinningResults(List<Lotto> lottoBundle, WinningNumbers winningNumbers) {
        // init
        Map<LottoRank, Integer> winningResults = new HashMap<>();
        for (LottoRank lottoRank : LottoRank.values()) {
            winningResults.put(lottoRank, 0);
        }

        // getWinningResults
        for (Lotto lotto : lottoBundle) {
            LottoRank lottoRank = LottoRank.valueOf(lotto, winningNumbers);
            winningResults.put(lottoRank, winningResults.get(lottoRank) + 1);
        }

        return winningResults;
    }

    public long calculateTotalPrize(Map<LottoRank, Integer> getWinningResults) {
        long totalPrize = 0L;
        for (LottoRank lottoRank : getWinningResults.keySet()) {
            totalPrize += lottoRank.getPrize() * getWinningResults.get(lottoRank);
        }
        return totalPrize;
    }

    public double calculateProfitRate(long totalPrize, int purchaseAmount) {
        return (totalPrize / (double) purchaseAmount) * 100;
    }

    public int calculateLottoCount(int purchaseAmount) {
        return purchaseAmount / LOTTO_PRICE;
    }
}
