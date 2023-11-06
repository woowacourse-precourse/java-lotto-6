package controller;

import static view.InputView.inputBonusNumber;
import static view.InputView.inputLottoPurchaseAmount;
import static view.InputView.inputWinningLottoNumber;


import domain.Amount;
import domain.Lotto;
import domain.Lottos;
import domain.WinningLotto;


public class LottoController {
    public void start() {
        Amount amount = inputLottoPurchaseAmount();
        amount.outputLottoPurchaseAmount();
        Lottos lottos = amount.buyLotto();
        lottos.outputLottos();
        WinningLotto winningLotto = new WinningLotto(inputWinningLottoNumber(), inputBonusNumber());
    }

}
