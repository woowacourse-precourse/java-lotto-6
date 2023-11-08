package lotto.controller;

import lotto.domain.*;
import lotto.service.LottoService;

import java.util.Map;

public class LottoController {
    private final LottoService lottoService;
    public LottoController(LottoService lottoService) { this.lottoService = lottoService; }
    public void start() {
        Money money = lottoService.putMoney();
        Lottos userLottos = lottoService.buyLottos(money);
        WinnerLotto winnerLotto = lottoService.putWinnerLotto();
        Map<LottoRank, Integer> userLottoResultsRank = lottoService.calculateLottoResults(userLottos, winnerLotto);
        lottoService.calculateProfit(userLottoResultsRank, money);
    }
}
