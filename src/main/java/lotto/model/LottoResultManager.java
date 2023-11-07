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

    public LottoResultManager(List<Lotto> lottos, LottoRankPolicy lottoJudgePolicy) {
        this.lottos = lottos;
        this.lottoRankPolicy = lottoJudgePolicy;
        calculateLottoResults();
    }

    private void calculateLottoResults() {
        for (Lotto lotto : lottos) {
            String lottoRank = lottoRankPolicy.getRank(lotto);
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
