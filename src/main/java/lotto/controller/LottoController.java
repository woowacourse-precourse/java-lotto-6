package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.WinnerLotto;
import lotto.service.LottoService;

public class LottoController {
    private final LottoService lottoService;
    public LottoController(LottoService lottoService) { this.lottoService = lottoService; }
    public void start() {
        Money money = lottoService.putMoney();
        Lottos userLottos = lottoService.buyLottos(money);
        WinnerLotto winnerLotto = lottoService.putWinnerLotto();
        lottoService.calculateLottoResults(userLottos, winnerLotto);
    }
}
