package lotto.service;

import lotto.domain.PurchasePrice;
import lotto.domain.LottoStatistics;
import lotto.domain.Lottos;
import lotto.domain.WinningLotto;
import lotto.dto.LottoResultFormatter;
import lotto.dto.LottoStatisticsResultFormatter;

public class LottoService {

    private final Lottos lottos;
    private final LottoStatistics lottoStatistics;
    private WinningLotto winningLotto;


    public LottoService(Lottos lottos, LottoStatistics lottoStatistics) {
        this.lottos = lottos;
        this.lottoStatistics = lottoStatistics;
    }

    public void saveLottos(PurchasePrice lottoPurchasePrice) {
        lottos.saveLottos(lottoPurchasePrice);
    }

    public LottoResultFormatter getLottos() {
        return new LottoResultFormatter(lottos.getLottoValues());
    }

    public void saveWinningLotto(WinningLotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public void calculateWinningStatistics() {
        lottoStatistics.calculateLottoMatch(lottos, winningLotto);
    }

    public void calculateTotalRate() {
        lottoStatistics.calculateTotalRate(lottos);
    }

    public LottoStatisticsResultFormatter getStatistics() {
        return new LottoStatisticsResultFormatter(lottoStatistics.getStatistics(), lottoStatistics.getTotalRate());
    }
}
