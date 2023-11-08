package lotto.controller;

import lotto.domain.*;
import lotto.service.LottoService;
import lotto.service.RankingService;

public class GameController {

    public void play() {
        LottoService lottoService = new LottoService();
        Money money = lottoService.inputMoney();
        Lottos lottos = lottoService.buy(money);
        WinningLotto winningLotto = lottoService.setWinningLotto();

        RankingService rankingService = new RankingService(winningLotto, lottos, money);
        rankingService.result();
    }
}
