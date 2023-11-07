package lotto.service;

import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lottogenerator.LottoGenerator;
import lotto.domain.lottoseller.LottoSeller;
import lotto.domain.money.Money;
import lotto.domain.ranking.LottoRanking;
import lotto.domain.statistic.Statistic;
import lotto.domain.winninglotto.WinningLotto;

public class LottoService {

    private final LottoSeller lottoSeller;

    private LottoService(LottoSeller lottoSeller) {
        this.lottoSeller = lottoSeller;
    }

    public static LottoService init(LottoGenerator lottoGenerator) {
        LottoSeller lottoSeller = new LottoSeller(lottoGenerator);
        return new LottoService(lottoSeller);
    }

    public Money createMoney(int value) {
        return Money.valueOf(value);
    }

    public List<Lotto> purchaseLotto(Money money) {
        return lottoSeller.sell(money);
    }

    public WinningLotto createWinningLotto(List<Integer> winningLottoNumbers, int bonusNumber) {
        return WinningLotto.of(winningLottoNumbers, bonusNumber);
    }

    public Statistic judgeAll(WinningLotto winningLotto, List<Lotto> buyingLottos) {
        Statistic statistic = Statistic.init();

        buyingLottos.forEach(lotto -> {
            LottoRanking ranking = winningLotto.judge(lotto);
            statistic.addCount(ranking);
        });

        return statistic;
    }

    public double calculateEarningRate(Statistic statistic) {
        return statistic.calculateEarningRate();
    }
}
