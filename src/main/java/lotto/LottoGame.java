package lotto;

import lotto.controller.LottoController;

public class LottoGame {
    private final LottoController lottoController;

    public LottoGame() {
        this.lottoController = new LottoController();
    }

    public void play() {
        lottoController.buyLotto();

        lottoController.readBoughtLotto();

        lottoController.setupWinningLotto();

        lottoController.processWinningResult();
    }

}
