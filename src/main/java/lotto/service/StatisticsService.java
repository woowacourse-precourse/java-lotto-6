package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoRanking;
import lotto.domain.LottoResult;
import lotto.domain.WinningLotto;
import lotto.repository.PrizeMoneyRepository;

import java.util.List;

public class StatisticsService {
    private final PrizeMoneyRepository prizeMoneyRepository;

    public StatisticsService(PrizeMoneyRepository prizeMoneyRepository) {
        this.prizeMoneyRepository = prizeMoneyRepository;
    }

    public LottoResult checkLottoResult(WinningLotto winningLotto, List<Lotto> userLottos) {
        LottoResult lottoResult = new LottoResult();

        for (Lotto userLotto : userLottos) {
            LottoRanking ranking = winningLotto.compare(userLotto);
            lottoResult.record(ranking);
        }

        return lottoResult;
    }
}
