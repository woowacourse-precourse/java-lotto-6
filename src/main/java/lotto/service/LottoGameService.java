package lotto.service;

import lotto.domain.lotto.LottoGenerator;
import lotto.domain.lotto.LottoPurchase;
import lotto.domain.lotto.Lottos;
import lotto.domain.roulette.Roulette;
import lotto.domain.roulette.RouletteResult;
import lotto.domain.roulette.WinningLotto;

import java.util.Map;

public class LottoGameService {
    private LottoGenerator lottoGenerator;
    private Roulette roulette;
    private WinningLotto winningLotto;

    public LottoGameService() {
        this.lottoGenerator = new LottoGenerator();
    }

    public Lottos buyLottos(LottoPurchase lottoPurchase) {
        return lottoGenerator.buyLottos(lottoPurchase);
    }

    public Map<RouletteResult, Integer> match(WinningLotto winningLotto, Lottos lottos) {
        roulette = Roulette.of(winningLotto, lottos);
        roulette.getRouletteLottos();
        return roulette.getResult();
    }

    public double getRate(LottoPurchase lottoPurchase) {
        return roulette.getRateOfResult(lottoPurchase);
    }
}
