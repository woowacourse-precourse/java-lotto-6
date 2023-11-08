package lotto;

import lotto.controller.LottoController;

public class PlayLotto {
    public void play() {

        LottoController lottoController = new LottoController();
        lottoController.buyLotto();
        lottoController.printBuyLotto();
        lottoController.inputLottoNumber();
        lottoController.countLotto();
        lottoController.printRate();
    }
}
