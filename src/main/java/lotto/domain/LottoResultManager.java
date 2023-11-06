package lotto.domain;

import java.util.List;
import lotto.global.constant.WinningType;

public class LottoResultManager {

    private static final int COUNT = 1;

    private final LottoResults lottoResults;
    private final LottoStatistics lottoStatistics;

    public LottoResultManager(LottoResults lottoResults, LottoStatistics lottoStatistics) {
        this.lottoResults = lottoResults;
        this.lottoStatistics = lottoStatistics;
    }

    public void calculateResult(WinningLotto winningLotto) {
        for (LottoResult lottoResult : lottoResults.getLottoResults()) {
            lottoResult.calculateResult(winningLotto);
            WinningType key = lottoResult.getWinning();
            lottoStatistics.getStatistics()
                    .put(key, lottoStatistics.getStatistics().getOrDefault(key, 0) + COUNT);
        }
    }

    public List<LottoResult> getLottoResults() {
        return lottoResults.getLottoResults();
    }

    public LottoStatistics getStatistics() {
        return lottoStatistics;
    }
}
