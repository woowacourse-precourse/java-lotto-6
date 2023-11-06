package controller;

import static view.InputView.inputLottoPurchaseAmount;


import domain.Amount;
import domain.Lottos;


public class LottoController {
    public void start() {
        Amount amount = inputLottoPurchaseAmount();
        amount.outputLottoPurchaseAmount();
        Lottos lottos = amount.buyLotto();
        lottos.outputLottos();
    }

}
