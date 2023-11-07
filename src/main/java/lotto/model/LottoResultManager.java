package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.enums.LottoRank;

public class LottoResultManager {

    private final List<Lotto> lottos;
    private final RankPolicy lottoRankPolicy;
    private int winningAmount = 0;
    private Map<String, Integer> lottoResult = new HashMap<>();

    public LottoResultManager(List<Lotto> lottos, LottoRankPolicy lottoRankPolicy) {
        this.lottos = lottos;
        this.lottoRankPolicy = lottoRankPolicy;
        calculateLottoResults();
    }

    private void calculateLottoResults() {
        //TODO 구조 개선 필요
        for (Lotto lotto : lottos) {
            String lottoRank = lottoRankPolicy.calculateRank(lotto);
            winningAmount += LottoRank.valueOf(lottoRank).getPrizeAmount();
            lottoResult.put(lottoRank, lottoResult.getOrDefault(lottoRank, 0) + 1);
        }
    }

    public Map<String, Integer> getLottoResult() {
        return lottoResult;
    }

    public int getWinningAmount() {
        return winningAmount;
    }
}
