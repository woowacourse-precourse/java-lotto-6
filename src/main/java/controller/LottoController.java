package controller;

import static view.InputView.inputLottoPurchaseAmount;
import static view.InputView.inputWinningLottoNumber;


import domain.Amount;
import domain.Lotto;
import domain.Lottos;


public class LottoController {
    public void start() {
        Amount amount = inputLottoPurchaseAmount();
        amount.outputLottoPurchaseAmount();
        Lottos lottos = amount.buyLotto();
        lottos.outputLottos();
        Lotto winningLotto = inputWinningLottoNumber();
    }

}
