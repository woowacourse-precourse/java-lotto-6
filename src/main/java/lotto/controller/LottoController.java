package lotto.controller;

import lotto.domain.Budget;
import lotto.domain.LottoSize;
import lotto.domain.Lottos;
import lotto.service.LottoService;
import lotto.view.GameView;

public class LottoController {
    private final LottoService lottoService;
    private final GameView gameView;

    public LottoController() {
        lottoService = new LottoService();
        gameView = new GameView();
    }

    public Lottos createLottos(Budget budget) {
        Lottos lottos = lottoService.createLottos(budget);
        LottoSize lottosSize = lottoService.getLottosSize(lottos);
        gameView.printLottosSize(lottosSize.toString());

        return lottos;
    }

    public void printLottos(Lottos lottos){
        String lottosNumbers = lottoService.getLottosNumbers(lottos);

        gameView.printLottosNumbers(lottosNumbers);
    }
}
