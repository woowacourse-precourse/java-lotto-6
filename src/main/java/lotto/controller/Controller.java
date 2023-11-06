package lotto.controller;

import lotto.model.Lottos;
import lotto.view.InputView;

public class Controller {

    public void lottoGame() {
        buyLotto();
//        putWinningNumber();
//        checkWinningList()
//        calculateRate();
    }

    public void buyLotto() {
        InputView.requestPurchaseAmount();
        Lottos lottos = new Lottos();
    }
}
