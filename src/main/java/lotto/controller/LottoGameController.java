package lotto.controller;

import lotto.model.User;
import lotto.model.Wallet;
import lotto.model.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {
    Wallet wallet;
    User user = new User();
    WinningLotto winningLotto;

    public void start() {
        checkPurchaseAmount();
        buyLottoes();
    }

    private void checkPurchaseAmount() {
        boolean isSuccess = false;
        while (!isSuccess) {
            try {
                OutputView.printInputPurchaseAmountMessage();
                wallet = new Wallet(InputView.getUserInput());
                isSuccess = true;
            } catch (IllegalArgumentException illegalArgumentException) {
                OutputView.printErrorMessage(illegalArgumentException.getMessage());
            }
        }
    }

    private void buyLottoes() {
        while (wallet.canBuyLotto()) {
            wallet.buyLotto();
            user.pickLottoNumber();
        }
        OutputView.printPurchaseLottoesMessage(user.getLottoes());
    }
}
