package lotto.controller;

import lotto.domain.User;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {
    public void start() {
        OutputView.printPayInputMessage();
        User user = InputView.readPayment();
        int lottoCnt = user.getLottoCnt();
    }
}
