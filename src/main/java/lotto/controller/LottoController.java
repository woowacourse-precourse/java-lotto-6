package lotto.controller;

import lotto.domain.Computer;
import lotto.domain.User;
import lotto.domain.Winner;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    User user;
    Winner winner;
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void run() {
        user = new User(inputView.purchaseAmountMoney());
        outputView.printPurchaseLotto(user);
        winner = new Winner(inputView.lottoWinningNumber());
        winner.lottoWinningBonusNumber(inputView.lottoWinningBonus(winner.noticeLottoWinningNumbers()));
    }
}
