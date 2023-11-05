package lotto.controller;

import lotto.domain.Computer;
import lotto.domain.Lottos;
import lotto.domain.User;
import lotto.domain.Winner;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    User user;
    Computer computer;
    Winner winner;
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void run() {
        user = new User(inputView.purchaseAmountMoney());
        computer = new Computer();
        computer.drawRandomNumber(user, new Lottos());
        outputView.printPurchaseLotto(user);
        winner = new Winner(inputView.lottoWinningNumber());
    }
}
