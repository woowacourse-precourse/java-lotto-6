package lotto.controller;

import lotto.model.LottoResult;
import lotto.model.User;
import lotto.model.WinningNumber;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void run() {
        int amount = InputView.inputAmount();
        User user = User.from(amount);

        OutputView.printPurchasedLottos(user.purchaseLottos());

        String[] winningNumbers = InputView.inputWinningNumbers();
        int bonusNumber = InputView.inputBonusNumber();
        WinningNumber winningNumber = WinningNumber.from(winningNumbers, bonusNumber);

        LottoResult lottoResult = new LottoResult(user, winningNumber);
        OutputView.printLottoResult(lottoResult.getLottoResult(user.getPurchasedLottos(), winningNumber));
    }
}
