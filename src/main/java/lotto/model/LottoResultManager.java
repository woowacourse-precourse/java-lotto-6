package lotto.model;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.enums.LottoRank;

public class LottoResultManager {

    private final List<Lotto> lottos;
    private final ResultPolicy lottoResultPolicy;
    private long winningAmount = 0;
    private Map<LottoRank, Integer> lottoResults = new EnumMap<>(LottoRank.class);


    public LottoResultManager(List<Lotto> lottos, LottoResultPolicy lottoResultPolicy) {
        this.lottos = lottos;
        this.lottoResultPolicy = lottoResultPolicy;
        calculateLottoResults();
    }

    public long getWinningAmount() {
        return winningAmount;
    }

    public Map<LottoRank, Integer> getLottoResults() {
        return lottoResults;
    }

    private void calculateLottoResults() {
        for (LottoRank rank : LottoRank.values()) {
            lottoResults.put(rank, 0);
        }

        for (Lotto lotto : lottos) {
            LottoResult lottoResult = lottoResultPolicy.calculateResult(lotto);
            LottoRank rank = LottoRank.determineRank(lottoResult.getWinningCount(),
                lottoResult.isBonusMatch());
            if (rank != null) {
                int count = lottoResults.get(rank);
                lottoResults.put(rank, count + 1);
                winningAmount += rank.getPrizeAmount();
            }
        }
    }

}
