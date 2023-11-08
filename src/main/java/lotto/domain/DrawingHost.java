package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.repository.LottoRepository;

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

    private void getWinningResult() {
        List<Lotto> lottos = LottoRepository.getLottos();
        for (Lotto lotto : lottos) {
            Ranking rank = lottoChecker.checkOneLotto(lotto);
            winningResultMap.merge(rank, 1, Integer::sum);
        }
    }
}
