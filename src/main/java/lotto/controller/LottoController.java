package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.service.LottoService;

public class LottoController {
    private final LottoService lottoService;
    public LottoController(LottoService lottoService) { this.lottoService = lottoService; }
    public void start() {
        Money money = lottoService.putMoney();
        Lottos lottos = lottoService.buyLottos(money);
        Lotto winnerLotto = lottoService.putWinnerLotto();
        int bonusNumber = lottoService.putBonusNumber(winnerLotto);
    }
}
