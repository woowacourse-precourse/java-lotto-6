package lotto.controller;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;
import lotto.domain.lotto.WinningLotto;
import lotto.domain.money.Money;
import lotto.service.LottoGameService;

public class LottoGameController {
    private final LottoGameService lottoGameService;

    public LottoGameController(LottoGameService lottoGameService) {
        this.lottoGameService = lottoGameService;
    }

    public void play() {
        Money money = lottoGameService.purchaseAmount();
        Lottos lottos = lottoGameService.makeLottos(money);
        WinningLotto winningLotto = lottoGameService.winningLotto();
        lottoGameService.winningStats(money, lottos, winningLotto);
    }
}
