package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameController {


    public void start() {
        PurchaseAmount purchaseAmount = InputView.inputPurchaseAmount();
        OutputView.showBayLottoCount(purchaseAmount.getLottoCount());

        LottoMachine lottoMachine = new LottoMachine();
        Lottos lottos = lottoMachine.createLottos(purchaseAmount.getLottoCount());

        OutputView.showBayLottoNumber(lottos);

        WinningNumber winningNumber = InputView.inputLottoWinningNumbers();
        BonusNumber bonusNumber = InputView.inputLottoBonusNumbers();

        LottoResult lottoResult = new LottoResult(lottos, winningNumber, bonusNumber, purchaseAmount);
        OutputView.showLottoResult(lottoResult);
    }

}