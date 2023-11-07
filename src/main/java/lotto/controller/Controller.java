package lotto.controller;

import lotto.model.Lottos;
import lotto.view.InputView;

public class Controller {

    public void lottoGame() {
        buyLottos();
//        putWinningNumber();
//        checkWinningList()
//        calculateRate();
    }

    public void buyLottos() {
        InputView.requestPurchaseAmount();
        Lottos lottos = new Lottos();
        lottos.howManyLottos();
    }
}