package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.repository.LottoRepository;
import lotto.utils.CalculateUtility;
import lotto.view.OutputView;

public class DrawingHost {
    private Map<Ranking, Integer> winningResultMap;
    private LottoChecker lottoChecker;

    public DrawingHost(LottoChecker lottoChecker) {
        this.lottoChecker = lottoChecker;
        winningResultMap = new HashMap<>();
        for (Ranking rank : Ranking.values()) {
            winningResultMap.put(rank, 0);
        }
    }

    public void produceResults() {
        getWinningResult();
        Long prizeSum = CalculateUtility.calculatePrizeSum(winningResultMap);
        double earningsRate = CalculateUtility.calculateEarningsRate(prizeSum, LottoRepository.getBudget());
        OutputView.printStats(winningResultMap, earningsRate);
    }

    private void getWinningResult() {
        List<Lotto> lottos = LottoRepository.getLottos();
        for (Lotto lotto : lottos) {
            Ranking rank = lottoChecker.checkOneLotto(lotto);
            winningResultMap.merge(rank, 1, Integer::sum);
        }
    }
}
