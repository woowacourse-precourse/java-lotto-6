package lotto.controller;

import lotto.domain.*;
import lotto.service.LottoService;
import lotto.service.RankingService;
import lotto.view.InputView;

public class GameController {

    public void play() {
        InputView inputView = new InputView();
        LottoService lottoService = new LottoService(inputView);
        Money money = lottoService.inputMoney();
        Lottos lottos = lottoService.buy(money);
        WinningLotto winningLotto = lottoService.setWinningLotto();

        RankingService rankingService = new RankingService(winningLotto, lottos, money);
        rankingService.result();
    }
}
