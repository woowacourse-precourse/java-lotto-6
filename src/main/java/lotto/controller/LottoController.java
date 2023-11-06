package lotto.controller;

import lotto.model.BonusNumber;
import lotto.model.Lottos;
import lotto.model.PurchaseAmount;
import lotto.model.WinningLotto;
import lotto.model.WinningNumber;
import lotto.model.WinningResult;
import lotto.util.Parser;
import lotto.view.InputView;

public class LottoController {

    public void run() {
        PurchaseAmount purchaseAmount = new PurchaseAmount(readPurchaseAmount());

        Lottos lottos = new Lottos(purchaseAmount);
        lottos.displayLottos();

        WinningLotto winningLotto = readWinningLotto();

        WinningResult winningResult = lottos.calculateWinningResult(winningLotto);
        winningResult.displayWinningResult();
    }

    private WinningLotto readWinningLotto() {
        return new WinningLotto(readWinningNumber(), readBonusNumber());
    }

    private BonusNumber readBonusNumber() {
        int bonusNumber = Parser.parseToInt(InputView.readBonusNumber());
        return new BonusNumber(bonusNumber);
    }

    private WinningNumber readWinningNumber() {
        String winningNumber = InputView.readWinningNumbers();
        return new WinningNumber(Parser.parseToIntListWithComma(winningNumber));
    }

    private int readPurchaseAmount() {
        return Parser.parseToInt(InputView.readPurchaseAmount());
    }
}
