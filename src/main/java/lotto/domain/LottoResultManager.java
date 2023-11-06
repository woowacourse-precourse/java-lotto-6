package lotto.domain;

import java.util.List;
import java.util.Map;
import lotto.global.constant.WinningType;

public class LottoResultManager {

    private final LottoResults lottoResults;
    private final LottoStatistics lottoStatistics;
    private long totalRevenue;

    public LottoResultManager(LottoResults lottoResults, LottoStatistics lottoStatistics) {
        this.lottoResults = lottoResults;
        this.lottoStatistics = lottoStatistics;
    }

    public void calculateResult(WinningLotto winningLotto) {
        for (LottoResult lottoResult : lottoResults.getLottoResults()) {
            lottoResult.calculateResult(winningLotto);
            WinningType key = lottoResult.getWinning();
            lottoStatistics.getStatistics().put(key, lottoStatistics.getStatistics().getOrDefault(key, 0) + 1);
            totalRevenue += lottoResult.getWinning().getRevenue();
        }
    }

    public List<LottoResult> getLottoResults() {
        return lottoResults.getLottoResults();
    }

    public Map<WinningType, Integer> getStatistics() {
        return lottoStatistics.getStatistics();
    }

    public long getTotalRevenue() {
        return totalRevenue;
    }
}
